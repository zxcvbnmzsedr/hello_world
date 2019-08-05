package com.ztianzeng.learn.framework.axon;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

/**
 * @author zhaotianzeng
 * @date 2019-08-05 14:58
 * @version V1.0
 */
public class RedeemCardCommand {

    @TargetAggregateIdentifier
    private final String cardId;
    private final String transactionId;
    private final Integer amount;

    public RedeemCardCommand(String cardId, String transactionId, Integer amount) {
        this.cardId = cardId;
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public String getCardId() {
        return cardId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public Integer getAmount() {
        return amount;
    }
}