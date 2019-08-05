package com.ztianzeng.learn.framework.axon;

/**
 * @author zhaotianzeng
 * @date 2019-08-05 16:34
 * @version V1.0
 */
public class CardIssuedEvent {
    private final String cardId;
    private final Integer amount;

    public CardIssuedEvent(String cardId, Integer amount) {
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