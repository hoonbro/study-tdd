package org.example.blackjack.step1;

public class Dealer extends User{

    public boolean canDraw(){
        return hand.getScore() < 17;
    }
}
