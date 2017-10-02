package game.util;

import game.model.Card;
import game.model.Deck;
import game.response.CardResponse;
import game.response.DrawCardResponse;
import game.response.DeckResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fred on 9/28/17.
 */
public class ResponseHandler {

    public static Deck DeckResponseToDeck(DeckResponse response) {
        Deck deck = new Deck();
        deck.setId(response.getDeckId());
        deck.setRemining(response.getRemaining());
        return deck;
    }

    public static List<Card> getCards(DrawCardResponse response) {
        List<Card> cards = new ArrayList<>();
        for (CardResponse cardResponse : response.getCards()) {
            Card card = new Card();
            card.setCode(cardResponse.getCode());
            card.setImage(cardResponse.getImage());
            card.setSuit(cardResponse.getSuit());
            card.setValue(cardResponse.getValue());
            cards.add(card);
        }

        return cards;
    }
}
