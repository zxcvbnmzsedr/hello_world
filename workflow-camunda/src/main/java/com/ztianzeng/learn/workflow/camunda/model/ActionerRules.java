package com.ztianzeng.learn.workflow.camunda.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-19 18:23
 */
@Data
public class ActionerRules {
    /**
     * 0 只能选择单人 1 可以选择多人
     */
    private Integer multi;


    /**
     * 选择类型
     * 发起人自选: target_select
     * 发起人自自己: target_self
     * 后台指定人了，不可选择: target_approval
     */
    private ActionerRulesType type;

    /**
     * 固定审批人
     */
    private List<ApprovalUser> approvals;

    /**
     * 审批人选择范围
     */
    private AactionerRulesRange range;
}