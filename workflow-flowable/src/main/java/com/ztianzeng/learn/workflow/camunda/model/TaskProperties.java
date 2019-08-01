package com.ztianzeng.learn.workflow.camunda.model;

import lombok.Data;

import java.util.List;


/**
 * 任务参数
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-19 17:11
 */
@Data
public class TaskProperties {
    /**
     * 类型
     * 抄送人: NOTIFIER
     * 审批人: APPROVER
     * 条件: CONDITION
     * 路由: ROUTE
     */
    private TaskType type;


    /**
     * 选择人规则
     */
    private List<ActionerRules> actionerRules;


    /**
     * 单个选择规则
     */
    private ActionerRules actionerRule;

    /**
     * 是否所有人同意才走下一步（是否会签）
     */
    private Boolean agreeAll;
    /**
     * 选择人类型 一个接着一个选择,顺序审批、
     */
    private Boolean sequential;

    /**
     * 是否可编辑
     */
    private Boolean edit;

    /**
     * 约束条件
     */
    private List<Conditions> conditions;


}