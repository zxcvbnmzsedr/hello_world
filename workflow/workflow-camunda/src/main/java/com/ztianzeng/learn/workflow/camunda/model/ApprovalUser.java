package com.ztianzeng.learn.workflow.camunda.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

/**
 * @author zhaotianzeng
 * @version V1.0
 * @date 2019-06-19 18:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApprovalUser {
    /**
     * 组织结构名
     */
    private String orgName;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 人的审批状态
     */
    private StatusText statusE;

    /**
     * 格式化时间
     */
    private String formatTime;

    /**
     * 用户评论
     */
    private String comment;

    public String getStatusText() {
        return Optional.ofNullable(statusE).map(StatusText::getDesc).orElse(null);
    }

    public Integer getStatus() {
        return Optional.ofNullable(statusE).map(StatusText::getValue).orElse(null);
    }


}