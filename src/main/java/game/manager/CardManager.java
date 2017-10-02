package game.manager;

import game.model.Card;
import game.model.Deck;

import java.util.List;

/**
 * Created by fred on 9/28/17.
 */
public interface CardManager {

    public Deck newDeck();
    public Deck shuffle(int deckCount);
    public List<Card> drawCards(Deck deck, int cardCount);
    public void reShuffle(Deck deck);

}
