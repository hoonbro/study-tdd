package org.example.blackjack.step1.cards;

import org.example.blackjack.step1.cards.Card;
import org.example.blackjack.step1.cards.CardShape;
import org.example.blackjack.step1.cards.CardValue;

import java.util.*;

public class Deck {
    private List<Card> cardList;

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

    public int size(){
        return cardList.size();
    }

    public Set<Card> toSet(){
        return new HashSet<>(cardList);
    }

    public List<Card> toList(){
        return new ArrayList<>(cardList);
    }
}
