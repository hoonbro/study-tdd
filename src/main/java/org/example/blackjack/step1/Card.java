package org.example.blackjack.step1;

import java.util.Objects;

public class Card {

    private final CardShape shape;
    private final CardValue value;


    public Card(CardShape shape, CardValue value){
        this.shape = shape;
        this.value = value;
    }

    public int getScore(){
        return value.getScore();
    }

    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;

        if(!(o instanceof Card))
            return false;

        Card card = (Card) o;

        return this.shape.equals(card.shape)
                && this.value.equals(card.value);
    }

    @Override
    public int hashCode(){
        return Objects.hash(shape, value);
    }
}
