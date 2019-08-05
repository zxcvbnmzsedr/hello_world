package com.ztianzeng.learn.workflow.camunda.model;

import com.ztianzeng.learn.workflow.camunda.utils.WorkFlowUtils;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.ztianzeng.learn.workflow.camunda.model.BpmnModelConstants.*;

/**
 * The type Conditions.
 *
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019 -06-19 17:37
 */
@Data
public class Conditions {

    /**
     * 提交数据的key
     */
    private String dataKey;

    /**
     * 数据上边界
     * dataKey < upperBound
     */
    private String upperBound;

    /**
     * 数据下边界
     * dataKey > lowerBoundNotEqual
     */
    private String lowerBound;


    /**
     * dataKey >= lowerBoundEqual
     */
    private String lowerBoundEqual;

    /**
     * dataKey <= upperBoundEqual
     */
    private String upperBoundEqual;

    /**
     * 约束等于
     */
    private String boundEqual;

    /**
     * 条件类型
     */
    private String type;

    /**
     * 审批人信息
     */
    private List<ApprovalUser> users;

    /**
     * 选择
     */
    private List<Options> options;

    /**
     * 前端字段
     */
    private String conditionType;
    /**
     * 前端字段
     */
    private String lowType;
    /**
     * 前端字段
     */
    private String upType;
    /**
     * 前端字段
     */
    private String formId;
    /**
     *
     */
    private String label;


    /**
     * Gets express.
     *
     * @return the express
     */
    public String getExpress() {
        String key = WorkFlowUtils.getMixString(Optional.ofNullable(dataKey).filter(StringUtils::isNotEmpty).orElse(formId));

        List<String> express = new ArrayList<>();
        // 如果条件为申请人的类型
        if (Objects.equals(CONDITION_APPLY, type)) {
            for (ApprovalUser user : users) {
                express.add(CONDITION_APPLY_USER_ID + " == '" + user.getUserId() + "'");
            }
            return StringUtils.join(express, " or ");
        }
        if (Objects.equals(CONDITION_RADIO, type)) {
            for (Options s : options) {
                express.add(key + " == '" + s.getValue() + "'");
            }
            return StringUtils.join(express, " or ");
        }
        if (StringUtils.isNotEmpty(boundEqual)) {
            express.add(key + " == " + boundEqual);
        }

        if (StringUtils.isNotEmpty(upperBoundEqual)) {
            express.add(key + " <= " + upperBoundEqual);
        }

        if (StringUtils.isNotEmpty(lowerBoundEqual)) {
            express.add(key + " >= " + lowerBoundEqual);
        }
        if (StringUtils.isNotEmpty(lowerBound)) {
            express.add(key + " > " + lowerBound);
        }
        if (StringUtils.isNotEmpty(upperBound)) {
            express.add(key + " < " + upperBound);
        }

        return StringUtils.join(express, " and ");

    }
}