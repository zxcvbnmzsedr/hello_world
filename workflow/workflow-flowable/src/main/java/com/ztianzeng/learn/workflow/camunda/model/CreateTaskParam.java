package com.ztianzeng.learn.workflow.camunda.model;

import lombok.Data;

import java.util.List;

/**
 * 创建流程
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-18 16:04
 */
@Data
public class CreateTaskParam {

    /**
     * 唯一ID 发起事件写死 apply
     */
    private String nodeId;

    /**
     * 上一个节点的ID
     */
    private String prevId;

    /**
     * 流程名称
     */
    private String name;

    /**
     * 类型
     * 抄送人: NOTIFIER
     * 审批人: APPROVER
     * 条件: CONDITION
     * 路由: ROUTE
     */
    private TaskType type;


    /**
     * 任务属性
     */
    private TaskProperties properties;


    /**
     * 下一个任务
     */
    private CreateTaskParam childNode;
    /**
     * 条件分支
     */
    private List<CreateTaskParam> conditionNodes;

    /**
     * 等级
     */
    private Integer level;


    public CreateTaskParam() {
        properties = new TaskProperties();
    }
}