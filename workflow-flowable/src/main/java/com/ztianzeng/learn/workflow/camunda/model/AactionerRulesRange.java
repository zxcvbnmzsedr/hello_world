package com.ztianzeng.learn.workflow.camunda.model;

import lombok.Data;

import java.util.List;

/**
 * 发起人选择范围
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-19 18:29
 */
@Data
public class AactionerRulesRange {
    private List<ApprovalUser> approvals;

    /**
     * 1：全公司
     * 2：全项目
     * 3：指定人
     */
    private String type;
}