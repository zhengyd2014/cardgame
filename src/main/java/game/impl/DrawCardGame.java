package game.impl;

import game.manager.CardManager;
import game.manager.RestfulCardManager;
import game.model.*;
import game.rest.api.Client;
import game.rest.impl.httpurlconnection.HttpConnectionClient;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fred on 9/30/17.
 */
public class DrawCardGame implements CardGame, Serializable {
    private static final long serialVersionUID = 12345L;

    private transient CardManager manager;
    private DrawCardHand hand;
    private Deck deck;

    public DrawCardHand getHand() {
        return hand;
    }
    public Deck getDeck() {
        return deck;
    }

    public void init() {

        // builder pattern
        Client client = new HttpConnectionClient()
                .disableContentCompression()
                .setConnectionTimeout(3000);
        manager = new RestfulCardManager(client);
        hand = new DrawCardHand("player1");
        deck = manager.newDeck();
    }

    public void play(GameCommand command) {
        switch (command) {
            case drawcard:
                List<Card> cardList = manager.drawCards(deck, 1);
                hand.addCards(cardList);
                break;
            case reshuffle:
                manager.reShuffle(deck);
                break;
            default:
                System.out.println(command.toString() + " not support");
        }
    }
}
