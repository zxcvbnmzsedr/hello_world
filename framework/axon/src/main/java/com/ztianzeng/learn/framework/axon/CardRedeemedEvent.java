package com.ztianzeng.learn.framework.axon;

/**
 * @author zhaotianzeng
 * @date 2019-08-05 16:35
 * @version V1.0
 */
public class CardRedeemedEvent {
    private String id;
    private String transactionId;


    private int amount;

    public CardRedeemedEvent(String transactionId, int amount) {
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public CardRedeemedEvent(String id, String transactionId, int amount) {
        this.id = id;
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getTransactionId() {
        return transactionId;
    }

}