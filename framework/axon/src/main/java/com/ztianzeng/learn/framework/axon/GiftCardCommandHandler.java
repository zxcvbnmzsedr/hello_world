package com.ztianzeng.learn.framework.axon;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.modelling.command.Repository;

/**
 * @author zhaotianzeng
 * @date 2019-08-05 15:13
 * @version V1.0
 */
public class GiftCardCommandHandler {
    private final Repository<GiftCard> giftCardRepository;

    public GiftCardCommandHandler(Repository<GiftCard> giftCardRepository) {
        this.giftCardRepository = giftCardRepository;
    }

    @CommandHandler
    public void handle(RedeemCardCommand cmd) {
        giftCardRepository.load(cmd.getCardId())
                .execute(giftCard -> giftCard.handle(cmd));
    }
}