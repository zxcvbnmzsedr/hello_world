/**
 * Copyright  2017 - 2020 Cnabc. All Rights Reserved.
 */
package com.ztianzeng.learn.workflow.camunda.model;

/**
 * @Program: cnabc-workflow-center
 * @Author xulin
 * @Description: 开始流程实例请求类
 * @Create: 2018/12/17 19:11
 * @Version V1.0
 */
public interface BpmnModelConstants {


    /**
     * 会签变量key
     */
    String ACT_MUIT_VAR_NAME = "leader";



    /**
     * 条件，申请人ID
     */
    String CONDITION_APPLY_USER_ID = "applyUserId";

    /**
     * 条件类型，申请
     */
    String CONDITION_APPLY = "apply";
    /**
     * 单选框
     */
    String CONDITION_RADIO = "radio";



}
