package com.ztianzeng.learn.workflow.camunda.service;


import com.ztianzeng.learn.workflow.camunda.model.*;
import com.ztianzeng.learn.workflow.camunda.utils.JacksonUtils;
import com.ztianzeng.learn.workflow.camunda.utils.WorkFlowUtils;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.Process;
import org.activiti.bpmn.model.*;
import org.apache.commons.collections4.CollectionUtils;
import org.camunda.bpm.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.ztianzeng.learn.workflow.camunda.model.TaskType.*;
import static com.ztianzeng.learn.workflow.camunda.utils.WorkFlowUtils.*;

/**
 * 租户流程配置
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-24 19:54
 */
@Service
public class TenantProcessService {
    @Autowired
    private RepositoryService repositoryService;

    /**
     * 创建的规则
     */
    private ThreadLocal<Map<String, TaskProperties>> rulesMap = new ThreadLocal<>();

    /**
     * 重复的线
     */
    private ThreadLocal<Map<String, String>> repeat = new ThreadLocal<>();

    private ThreadLocal<Map<String, CreateTaskParam>> noTreeListT = new ThreadLocal<>();

    /**
     * 创建流程
     *
     * @param processDefinitionKey 流程
     * @param process              流程入对象
     */
    public Map<String, TaskProperties> createProcess(String tenantId, String processDefinitionKey, CreateTaskParam process) {
        // 1. 创建一个空的BpmnModel和Process对象
        BpmnModel model = new BpmnModel();
        repeat.set(new HashMap<>(10));
        model.addProcess(toProcess(processDefinitionKey, process));


        BpmnXMLConverter converter = new BpmnXMLConverter();
        byte[] bytes = converter.convertToXML(model);
        System.out.println(new String(bytes));

//        repositoryService.createDeployment()
//                .addInputStream(processDefinitionKey + ".bpmn", new ByteInputStream(bytes, bytes.length))
//                .name(processDefinitionKey)
//                .tenantId(tenantId)
//                .deploy();
        Map<String, TaskProperties> stringTaskPropertiesMap = rulesMap.get();
        rulesMap.remove();
        noTreeListT.remove();
        repeat.remove();
        return stringTaskPropertiesMap;

    }


    /**
     * 非树结构
     *
     * @param processParam 流程
     * @return
     */
    public List<CreateTaskParam> noTreeTask(CreateTaskParam processParam) {
        List<CreateTaskParam> list = new LinkedList<>();
        noTreeTask(list, processParam);
        return list;
    }

    /**
     * 非树结构
     *
     * @param params       存储流程
     * @param processParam 流程定义
     * @return
     */
    public void noTreeTask(List<CreateTaskParam> params, CreateTaskParam processParam) {
        params.add(processParam);
        if (processParam.getChildNode() != null) {
            noTreeTask(params, processParam.getChildNode());
        }
        if (processParam.getConditionNodes() != null) {
            for (CreateTaskParam conditionNode : processParam.getConditionNodes()) {
                noTreeTask(params, conditionNode);
            }
        }
    }


    /**
     * 转换成流程定义
     * 完成基本的流程定义操作
     *
     * @param processDefinitionKey 流程定义KEY
     * @param processParam         创建时的对象
     * @return
     */
    public Process toProcess(String processDefinitionKey, CreateTaskParam processParam) {
        Process process = new Process();
        process.setId(processDefinitionKey);
        process.addFlowElement(createStartEvent());
        if (rulesMap.get() == null) {
            rulesMap.set(new HashMap<>(10));
        }
        return toProcess(process, processParam);
    }

    /**
     * 转换成activiti流程
     *
     * @param process      process
     * @param processParam 创建的参数
     */
    public Process toProcess(Process process, CreateTaskParam processParam) {
        CreateTaskParam childNode = processParam.getChildNode();
        while (childNode != null) {
            if (CollectionUtils.isEmpty(childNode.getConditionNodes())) {
                createTask(process, childNode);
                // 连接前后节点
                addSequenceFlow(process, childNode.getPrevId(), childNode.getNodeId());
            } else {
                for (CreateTaskParam conditionNode : childNode.getConditionNodes()) {
                    toProcess(process, conditionNode);
                }
            }
            childNode = childNode.getChildNode();
        }

        return process;
    }

    public void createTask(Process process, CreateTaskParam child) {
        FlowNode task = null;
        if (child.getType() == APPROVER) {
            task = createUserTask(child);
        } else if (child.getType() == NOTIFIER) {
            task = createServiceTask(child);
        } else if (child.getType() == ROUTE) {
            // 属性决定是是么样的网关类型

            ExclusiveGateway gate = new ExclusiveGateway();
            gate.setId(child.getNodeId());

        } else if (child.getType() == CONDITION) {
            String express = WorkFlowUtils.getExpress(child);
            task = new ManualTask();
            task.setId(child.getNodeId());
        } else if (child.getType() == TaskType.END) {
            task = createEndEvent();
        }
        process.addFlowElement(task);


    }

    /**
     * 通知流程
     *
     * @param taskParam 任务
     * @return
     */
    public ServiceTask createServiceTask(CreateTaskParam taskParam) {
        ServiceTask notifyTask = new ServiceTask();
        notifyTask.setId(taskParam.getNodeId());
        notifyTask.setName("抄送人");

        notifyTask.setImplementationType(ImplementationType.IMPLEMENTATION_TYPE_DELEGATEEXPRESSION);

        CustomProperty customProperty = new CustomProperty();

        notifyTask.setCustomProperties(Collections.singletonList(customProperty));
        return notifyTask;
    }


    /**
     * 连线
     * 子节点和父节点的子节点相连，领会精神，看不懂了就重写
     *
     * @param process 流程
     * @param child   连线对象
     */
    public void link(Process process, CreateTaskParam child) {
        List<CreateTaskParam> conditionNodes = child.getConditionNodes();

        CreateTaskParam d = JacksonUtils.convertValue(child, CreateTaskParam.class);
        if (d.getChildNode() == null) {
            String prevId = d.getPrevId();
            CreateTaskParam parent = noTreeListT.get().get(prevId);
            while (parent != null) {
                parent = noTreeListT.get().get(parent.getPrevId());
                if (parent.getChildNode() != null && parent.getType() == ROUTE) {
                    break;
                }
            }

            d = parent.getChildNode();

        } else {
            d = d.getChildNode();
        }

        for (CreateTaskParam conditionNode : conditionNodes) {
            CreateTaskParam c = JacksonUtils.convertValue(conditionNode, CreateTaskParam.class);
            while (c.getChildNode() != null) {
                c = c.getChildNode();
            }
            // 如果最后一个node类型是网关，将网关下的所有分支和那个父的最后一个相连
            if (c.getType() == ROUTE) {
                link(process, c);
            } else {
                // 最后一个nodeId连接到route的最后一个nodeId
                addSequenceFlow(process, c.getNodeId(), d.getNodeId());
            }
        }
    }

    /**
     * 向流程中添加流程连线信息
     *
     * @param process 流程信息
     * @param from    from
     * @param to      to
     */
    public void addSequenceFlow(Process process, String from, String to) {
        addSequenceFlow(process, from, to, null);
    }

    /**
     * 向流程中添加流程连线信息
     *
     * @param process 流程信息
     * @param from    from
     * @param to      to
     * @param express 条件
     */
    public void addSequenceFlow(Process process, String from, String to, String express) {
        String id = from + "_" + to;
        if (repeat.get().get(id) == null) {
            repeat.get().put(id, id);
            process.addFlowElement(createSequenceFlow(from, to, express));
        }
    }


    /**
     * 创建集合审批
     *
     * @param taskParam 任务实例
     * @return
     */
    public UserTask createUserTask(CreateTaskParam taskParam) {
        UserTask userTask = new UserTask();
        userTask.setName(Optional.ofNullable(taskParam.getName()).orElse("UNKNOWN"));
        userTask.setId(taskParam.getNodeId());

        List<String> candidateGroups = new LinkedList<>();

        userTask.setCandidateGroups(candidateGroups);

        List<ActionerRules> actionerRules = taskParam.getProperties().getActionerRules();

        if (CollectionUtils.isNotEmpty(actionerRules)) {
            for (ActionerRules actionerRule : actionerRules) {
                // 获取选取的类型 发起人自选、发起人自己、指定人
                ActionerRulesType type = actionerRule.getType();
                if (type != null) {
                    switch (type) {
                        // 流程节点上人是死的
                        case target_approval:
                            List<ApprovalUser> approvals = actionerRule.getApprovals();
                            if (CollectionUtils.isEmpty(approvals)) {
                            }

                            break;
                        case target_select:


                            break;
                        default:
                            break;
                    }
                }
            }
        }
        setMultiInstance(userTask,
                taskParam.getProperties().getAgreeAll(),
                taskParam.getProperties().getSequential(),
                getTargetApprovalVar(taskParam.getNodeId()));


        return userTask;
    }
}