package org.example.blackjack.step1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    List<Card> cardList;

    public Deck(){
        cardList = new ArrayList<>();
        deckInit();
    }

    private void deckInit(){
        for(CardShape shape : CardShape.values()){
            for(CardValue value : CardValue.values()){
                cardList.add(new Card(shape, value));
            }
        }

        shuffle();
    }

    public void shuffle(){
        Collections.shuffle(cardList);
    }

    public Card draw(){
        return cardList.remove(0);
    }
}
