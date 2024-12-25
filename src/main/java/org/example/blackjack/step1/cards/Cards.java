package org.example.blackjack.step1.cards;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private final List<Card> list;

    private int score;

    public Cards(){
        list = new ArrayList<>();
        score = 0;
    }

    public int getSize(){
        return list.size();
    }

    public int getScore(){
        return score;
    }

    public void addCard(Card card){
        list.add(card);
        score += card.getScore();
    }

}
