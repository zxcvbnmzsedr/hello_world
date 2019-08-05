package com.ztianzeng.learn.workflow.camunda.model;

/**
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-19 17:41
 */
public enum TaskType {
    /**
     * 抄送人
     */
    NOTIFIER,
    /**
     * 审批人
     */
    APPROVER,
    /**
     * 条件
     */
    CONDITION,
    /**
     * 路由
     */
    ROUTE,
    /**
     *
     */
    START,
    /**
     *
     */
    END
}