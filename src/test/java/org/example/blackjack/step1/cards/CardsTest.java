package org.example.blackjack.step1.cards;

import org.example.blackjack.step1.cards.Card;
import org.example.blackjack.step1.cards.CardShape;
import org.example.blackjack.step1.cards.CardValue;
import org.example.blackjack.step1.cards.Cards;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardsTest {

    private Cards cards ;
    @BeforeEach
    void setup(){
        cards = new Cards();

        cards.addCard(new Card(CardShape.SPADES, CardValue.ACE));
        cards.addCard(new Card(CardShape.HEARTS, CardValue.SEVEN));
        cards.addCard(new Card(CardShape.CLUBS, CardValue.THREE));
    }

    @Test
    void getScore() {
        assertThat(cards.getScore()).isEqualTo(11);
    }

    @Test
    void addCard() {
        int beforeSize = cards.getSize();
        cards.addCard(new Card(CardShape.DIAMONDS, CardValue.QUEEN));

        assertThat(beforeSize).isEqualTo(cards.getSize()-1);
    }
}