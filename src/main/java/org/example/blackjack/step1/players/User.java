package org.example.blackjack.step1.players;

import org.example.blackjack.step1.cards.Card;
import org.example.blackjack.step1.cards.Cards;

public abstract class User {
    protected Cards hand;

    public User(){
        hand = new Cards();
    }

    public void addCard(Card card){
        hand.addCard(card);
    }

    public boolean isBust(){
        return hand.getScore() > 21;
    }

    public abstract boolean canDraw();
}
