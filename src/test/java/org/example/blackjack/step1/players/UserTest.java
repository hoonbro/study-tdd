package org.example.blackjack.step1.players;

import org.example.blackjack.step1.cards.Card;
import org.example.blackjack.step1.cards.CardShape;
import org.example.blackjack.step1.cards.CardValue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class UserTest {

    private User dealer;
    private User player;

    @BeforeEach
    void setup(){
        dealer = new Dealer();
        dealer.addCard(new Card(CardShape.SPADES, CardValue.TEN));
        dealer.addCard(new Card(CardShape.HEARTS, CardValue.SIX));

        player = new Player();
        player.addCard(new Card(CardShape.DIAMONDS, CardValue.KING));
        player.addCard(new Card(CardShape.SPADES, CardValue.SEVEN));
    }

    @Test
    void 딜러_카드뽑기_가능(){
        assertThat(dealer.canDraw()).isTrue();
    }

    @Test
    void 딜러_카드뽑기_불가능(){
        dealer.addCard(new Card(CardShape.CLUBS, CardValue.ACE));

        assertThat(dealer.canDraw()).isFalse();
    }

    @Test
    void 플레이어_카드뽑기_가능(){
        assertThat(player.canDraw()).isTrue();
    }

    @Test
    void 플레이어_Bust(){
        player.addCard(new Card(CardShape.CLUBS, CardValue.FIVE));

        assertThat(player.isBust()).isTrue();
    }
}