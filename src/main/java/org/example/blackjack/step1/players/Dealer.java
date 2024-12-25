package org.example.blackjack.step1.players;

public class Dealer extends User{

    public boolean canDraw(){
        return hand.getScore() < 17;
    }
}
