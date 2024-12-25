package org.example.blackjack.step1.players;

public class Player extends User{
    @Override
    public boolean canDraw() {
        return hand.getScore() < 21;
    }
}
