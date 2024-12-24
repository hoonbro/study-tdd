package org.example.blackjack.step1;

public class Player extends User{
    @Override
    public boolean canDraw() {
        return hand.getScore() < 21;
    }
}
