package com.ztianzeng.learn.workflow.camunda.utils;


import com.ztianzeng.learn.workflow.camunda.model.ActionerRulesType;
import com.ztianzeng.learn.workflow.camunda.model.BpmnModelConstants;
import com.ztianzeng.learn.workflow.camunda.model.Conditions;
import com.ztianzeng.learn.workflow.camunda.model.CreateTaskParam;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.model.*;
import org.flowable.common.engine.impl.de.odysseus.el.ExpressionFactoryImpl;
import org.flowable.common.engine.impl.de.odysseus.el.util.SimpleContext;
import org.flowable.common.engine.impl.de.odysseus.el.util.SimpleResolver;
import org.flowable.common.engine.impl.javax.el.ExpressionFactory;
import org.flowable.common.engine.impl.javax.el.PropertyNotFoundException;
import org.flowable.common.engine.impl.javax.el.ValueExpression;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


/**
 * 工作流工具类
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-04 13:15
 */
public final class WorkFlowUtils {
    private WorkFlowUtils() {
    }

    public static final String START = "start";
    public static final String APPLY = "apply";
    public static final String END = "end";

    /**
     * 创建开始事件
     */
    public static StartEvent createStartEvent() {
        StartEvent startEvent = new StartEvent();
        startEvent.setId(START);
        startEvent.setName(START);
        startEvent.setInitiator("applicant");
        return startEvent;
    }

    /**
     * 创建结束事件
     */
    public static EndEvent createEndEvent() {
        EndEvent endEvent = new EndEvent();
        endEvent.setId(END);
        return endEvent;
    }

    /**
     * 创建带条件的连接线
     *
     * @param from                开始
     * @param to                  结束
     * @param conditionExpression 条件
     * @return
     */
    public static SequenceFlow createSequenceFlow(String from, String to, String conditionExpression) {
        SequenceFlow flow = new SequenceFlow();
        flow.setSourceRef(from);
        flow.setId(from + "_" + to);
        flow.setTargetRef(to);
        flow.setConditionExpression(conditionExpression);
        return flow;
    }


    /**
     * 创建连接线
     *
     * @param from 开始
     * @param to   结束
     * @return
     */
    public static SequenceFlow createSequenceFlow(String from, String to) {

        return createSequenceFlow(from, to, null);
    }

    /**
     * 创建第一个用户任务
     */
    public static UserTask createStartTask() {
        UserTask userTask = new UserTask();
        userTask.setName("发起申请");
        userTask.setId(APPLY);
        userTask.setAssignee("${applicant}");
        userTask.setCandidateUsers(Collections.singletonList("${applicant}"));
        return userTask;
    }

    /**
     * 设置会签任务、或者或签任务
     * <p>
     * 1、nrOfInstances 该会签环节中总共有多少个实例
     * 2、nrOfActiveInstances 当前活动的实例的数量，即还没有 完成的实例数量。
     * 3、nrOfCompletedInstances 已经完成的实例的数量
     * <p>
     * 或签，只要一个人完成，流程全完成
     * ${nrOfCompletedInstances == 1}
     * <p>
     * 会签，全部人完成才算完成
     * ${nrOfCompletedInstances==nrOfInstances}
     *
     * @param userTask    用户任务
     * @param counterSign 是否会签,否则是或签
     * @param sequential  是否按照顺序执行
     * @param inputData   提交的参数
     */
    public static void setMultiInstance(UserTask userTask, Boolean counterSign, Boolean sequential, String inputData) {
        // 设置受理人，这里应该和ElementVariable的值是相同的
        userTask.setAssignee("${" + BpmnModelConstants.ACT_MUIT_VAR_NAME + "}");

        // 获取多实例配置
        MultiInstanceLoopCharacteristics characteristics = new MultiInstanceLoopCharacteristics();
        // 这是死的,会调用CounterSignService动态获取审批的人，不需要在启动时传入
        characteristics.setInputDataItem(inputData);
        // 设置变量
        characteristics.setElementVariable(BpmnModelConstants.ACT_MUIT_VAR_NAME);
        // 设置为同时接收（false 表示不按顺序执行）
        if (BooleanUtils.toBoolean(sequential)) {
            counterSign = true;
        }
        characteristics.setSequential(BooleanUtils.toBoolean(sequential));
        // 设置条件（全部会签完转下步）
        if (BooleanUtils.toBoolean(counterSign)) {
            characteristics.setCompletionCondition("${nrOfCompletedInstances==nrOfInstances}");
        } else {
            characteristics.setCompletionCondition("${nrOfCompletedInstances == 1}");
        }
        userTask.setLoopCharacteristics(characteristics);
    }


    /**
     * 获取预设人的流程变量定义
     *
     * @param nodeId 节点ID
     * @return
     */
    public static String getTargetApprovalVar(String nodeId) {
        return ActionerRulesType.target_approval.name() + "_" + nodeId;
    }

    /**
     * 使用EL表达式获取网关下面的流程
     *
     * @param node        流程节点
     * @param vars        参数
     * @param defaultFlow 默认流程ID
     * @return
     */
    public static List<FlowNode> getOutgoingTask(String defaultFlow, FlowNode node, Map<String, Object> vars) {
        List<FlowNode> possibleTasks = new ArrayList<>();
        for (SequenceFlow sf : node.getOutgoingFlows()) {
            boolean next = false;
            if (sf.getConditionExpression() != null && !"${}".equals(sf.getConditionExpression())) {
                ExpressionFactory factory = new ExpressionFactoryImpl();
                SimpleContext context = new SimpleContext(new SimpleResolver());

                if (vars != null) {
                    for (Map.Entry<String, Object> v : vars.entrySet()) {
                        String key = WorkFlowUtils.getMixString(v.getKey());

                        if (v.getValue() instanceof Boolean) {
                            factory.createValueExpression(context, "${" + key + "}", Boolean.class).setValue(context, v.getValue());
                        } else if (v.getValue() instanceof java.util.Date) {
                            factory.createValueExpression(context, "${" + key + "}", java.util.Date.class).setValue(context, v.getValue());
                        } else if (v.getValue() instanceof Number) {
                            factory.createValueExpression(context, "${" + key + "}", Long.class).setValue(context, v.getValue());
                        } else {
                            factory.createValueExpression(context, "${" + key + "}", String.class).setValue(context, v.getValue());
                        }
                    }
                }

                ValueExpression expr1 = factory.createValueExpression(context, sf.getConditionExpression(), boolean.class);
                try {
                    next = (Boolean) expr1.getValue(context);
                } catch (PropertyNotFoundException pr) {

                }
            }
            // 如果不满足条件，走默认条件
            if (!next && StringUtils.isNotBlank(defaultFlow) && sf.getId().equals(defaultFlow)) {
                next = true;
            }

            if (next && sf.getTargetFlowElement() != null) {
                if (sf.getTargetFlowElement() instanceof ManualTask) {
                    List<SequenceFlow> outgoingFlows = ((ManualTask) sf.getTargetFlowElement()).getOutgoingFlows();
                    for (SequenceFlow outgoingFlow : outgoingFlows) {
                        if (outgoingFlow.getTargetFlowElement() instanceof UserTask) {
                            possibleTasks.add((FlowNode) outgoingFlow.getTargetFlowElement());
                        }
                        // 如果条件下面挂路由
                        if (outgoingFlow.getTargetFlowElement() instanceof Gateway) {
                            possibleTasks.add((FlowNode) outgoingFlow.getTargetFlowElement());
                        }
                        // 如果条件下面挂通知
                        if (outgoingFlow.getTargetFlowElement() instanceof ServiceTask) {
                            possibleTasks.add((FlowNode) outgoingFlow.getTargetFlowElement());
                        }
                    }
                }
                if (sf.getTargetFlowElement() instanceof UserTask) {
                    possibleTasks.add((UserTask) sf.getTargetFlowElement());
                }
                break;
            }

        }
        return possibleTasks;
    }


    /**
     * 获取条件
     * 最后拼接成 ${}的形式
     *
     * @param conditionNode 条件
     * @return
     */
    public static String getExpress(CreateTaskParam conditionNode) {
        List<Conditions> conditions = conditionNode.getProperties().getConditions();

        List<String> tempExpress = new ArrayList<>();
        if (conditions == null) {
            return null;
        }
        // 条件处理，外部and 内部自定
        for (Conditions cond : conditions) {
            tempExpress.add("(" + cond.getExpress() + ")");
        }
        if (tempExpress.isEmpty()) {
            return null;
        }
        return "${" + StringUtils.join(tempExpress, " and ") + "}";
    }

    /**
     * 获取混淆的String
     * 如果开头为数字则手动在最前面加上E
     *
     * @param dataKey key
     */
    public static String getMixString(String dataKey) {

        String key = dataKey;

        if (Character.isDigit(key.charAt(0))) {
            key = "E" + key;
        }
        return key.replace("-", "");

    }
}