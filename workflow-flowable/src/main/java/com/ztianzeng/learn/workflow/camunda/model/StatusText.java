/**
 * Copyright  2017 - 2020 Cnabc. All Rights Reserved.
 */
package com.ztianzeng.learn.workflow.camunda.model;

import java.util.Objects;

/**
 * @Program: cnabc-workflow-center
 * @Author xulin
 * @Description: 审批状态:0：审批中 1：已通过 2：已驳回
 * @Create: 2018/12/17 19:11
 * @Version V1.0
 */
public enum StatusText {

    /**
     *
     */
    PASSED(1, "已通过"),

    DISMISSED(2, "已拒绝"),

    CANCEL(3, "已撤销"),

    UNREVIEWED(0, "审批中"),


    INIT(4, "发起申请");

    private int value;
    private String desc;

    StatusText(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }


    /**
     * 根据value获取desc
     *
     * @param value value
     * @return
     */
    public static String getDescByValue(int value) {
        for (StatusText em : StatusText.values()) {
            if (em.getValue() == value) {
                return em.getDesc();
            }
        }
        return null;
    }

    /**
     * 根据value获取desc
     *
     * @param value value
     * @return
     */
    public static StatusText getByValue(Integer value) {
        for (StatusText em : StatusText.values()) {
            if (Objects.equals(em.getValue(), value)) {
                return em;
            }
        }
        return StatusText.UNREVIEWED;
    }
}
