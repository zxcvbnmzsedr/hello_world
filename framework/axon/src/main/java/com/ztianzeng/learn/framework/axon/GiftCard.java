package com.ztianzeng.learn.framework.axon;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;

import java.util.ArrayList;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

/**
 * @author zhaotianzeng
 * @date 2019-08-05 14:39
 * @version V1.0
 */
public class GiftCard {

    @AggregateIdentifier
    private String id;


    @AggregateMember // 1.
    private List<GiftCardTransaction> transactions = new ArrayList<>();

    private int remainingValue;

    @CommandHandler
    public GiftCard(IssueCardCommand cmd) {

        apply(new CardIssuedEvent(cmd.getCardId(), cmd.getAmount()));
    }

    @EventSourcingHandler // 4.
    public void on(CardIssuedEvent evt) {
        id = evt.getCardId();
    }

    @EventSourcingHandler
    public void on(CardRedeemedEvent evt) {
        // 1.
        transactions.add(new GiftCardTransaction(evt.getTransactionId(), evt.getAmount()));
    }

    @CommandHandler
    public void handle(RedeemCardCommand cmd) {
        if (cmd.getAmount() <= 0) {
            throw new IllegalArgumentException("amount <= 0");
        }
        if (cmd.getAmount() > remainingValue) {
            throw new IllegalStateException("amount > remaining value");
        }
        apply(new CardRedeemedEvent(id, cmd.getTransactionId(), cmd.getAmount()));
    }


    protected GiftCard() {

    }
}