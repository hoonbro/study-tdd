package org.example.blackjack.step1.players;

public class Dealer extends User{

    public boolean canDraw(){
        return hand.getSize() >= 2 && hand.getScore() < 17;
    }
}
