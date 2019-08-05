package com.ztianzeng.learn.framework.axon;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.EntityId;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * @author zhaotianzeng
 * @date 2019-08-05 15:07
 * @version V1.0
 */
public class GiftCardTransaction {
    @EntityId
    private String transactionId;

    private int transactionValue;
    private boolean reimbursed = false;

    public GiftCardTransaction(String transactionId, int transactionValue) {
        this.transactionId = transactionId;
        this.transactionValue = transactionValue;
    }

    public String getTransactionId() {
        return transactionId;
    }

    @CommandHandler
    public void handle(ReimburseCardCommand cmd) {
        if (reimbursed) {
            throw new IllegalStateException("Transaction already reimbursed");
        }
        apply(new CardReimbursedEvent(cmd.getCardId(), transactionId, transactionValue));
    }


}