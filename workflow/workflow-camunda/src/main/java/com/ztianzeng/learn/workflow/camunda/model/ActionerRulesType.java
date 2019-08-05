package com.ztianzeng.learn.workflow.camunda.model;

/**
 * 选人类型
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-19 18:27
 */
public enum ActionerRulesType {
    /**
     * 发起人自选
     */
    target_select,
    /**
     * 发起人自己
     */
    target_self,

    /**
     * 指定人
     */
    target_approval;

    /**
     * 是否能够编辑
     * 只有指定人不可编辑
     *
     * @return
     */
    public Integer canEdit() {
        return this == target_approval ? 0 : 1;
    }


}