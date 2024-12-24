package org.example.blackjack.step1;

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
