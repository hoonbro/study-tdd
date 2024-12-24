package org.example.blackjack.step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    private Card spadeAce,heartSeven,cloverThree,diamondQueen;

    @BeforeEach
    void setup(){
        spadeAce = new Card(CardShape.SPADES, CardValue.ACE);
        heartSeven = new Card(CardShape.HEARTS, CardValue.SEVEN);
        cloverThree = new Card(CardShape.CLUBS, CardValue.THREE);
        diamondQueen = new Card(CardShape.DIAMONDS, CardValue.QUEEN);
    }

    @Test
    void 카드_equals(){
        Card spadeAce2 = new Card(CardShape.SPADES, CardValue.ACE);

        assertThat(spadeAce).isEqualTo(spadeAce2);
    }

    @Test
    void 카드_notEquals(){
        Card heartAce = new Card(CardShape.HEARTS, CardValue.ACE);

        assertThat(spadeAce).isNotEqualTo(heartSeven);
        assertThat(spadeAce).isNotEqualTo(heartAce);
    }
}