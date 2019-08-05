package com.ztianzeng.learn.framework.axon;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author zhaotianzeng
 * @date 2019-08-05 14:45
 * @version V1.0
 */
public class IssueCardCommand {
    @TargetAggregateIdentifier
    private final String cardId;
    private final Integer amount;

    public IssueCardCommand(String cardId, Integer amount) {
        this.cardId = cardId;
        this.amount = amount;
    }

    public String getCardId() {
        return cardId;
    }

    public Integer getAmount() {
        return amount;
    }
}