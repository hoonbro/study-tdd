package org.example.blackjack.step1.game;

import org.example.blackjack.step1.cards.Deck;
import org.example.blackjack.step1.players.Dealer;
import org.example.blackjack.step1.players.User;

public class BlackjackGame {
    private final User dealer, player;
    private final Deck deck;

    public BlackjackGame(){
        dealer = new Dealer();
        player = new Dealer();
        deck= new Deck();
    }

    public void beginGame(){
        dealer.addCard(deck.draw());
        dealer.addCard(deck.draw());
        player.addCard(deck.draw());
        player.addCard(deck.draw());
    }
}
