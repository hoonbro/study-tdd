package org.example.blackjack.step1.cards;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DeckTest {

    private Deck deck;

    private int BASE_SIZE = 52;

    @BeforeEach
    void setup(){
        deck = new Deck();
    }

    @Test
    void 덱확인(){
        Set<Card> cardList = deck.toSet();

        assertThat(deck.size()).isEqualTo(BASE_SIZE);
        assertThat(deck.size()).isEqualTo(cardList.size());
    }

    @Test
    void shuffle() {
        List<Card> beforeShuffle = deck.toList();

        deck.shuffle();

        List<Card> afterShuffle = deck.toList();

        assertThat(beforeShuffle).isNotEqualTo(afterShuffle);
    }

    @Test
    void draw() {
        Card topCard = deck.toList().get(0);
        Card drawCard = deck.draw();

        assertThat(topCard).isEqualTo(drawCard);
        assertThat(deck.size()).isEqualTo(BASE_SIZE-1);
    }
}