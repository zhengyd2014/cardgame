package game.manager;

import com.google.gson.Gson;
import game.manager.CardManager;
import game.model.Card;
import game.model.Deck;
import game.response.DrawCardResponse;
import game.response.DeckResponse;
import game.util.RestClient;
import game.util.ResponseHandler;

import java.util.List;

/**
 * Created by fred on 9/28/17.
 */
public class RestfulCardManager implements CardManager {

    private static String SHUFFLE_URL = "https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=%s";
    private static String DRAW_CARD_URL = "https://deckofcardsapi.com/api/deck/%s/draw/?count=%s";
    private static String RESHUFFLE_URL = "https://deckofcardsapi.com/api/deck/%s/shuffle/";
    private static String NEW_DECK_URL = "https://deckofcardsapi.com/api/deck/new/";

    private RestClient restClient;

    public RestfulCardManager(RestClient client) {
        this.restClient = client;
    }

    @Override
    public Deck newDeck() {
        String response = restClient.getJSON(NEW_DECK_URL);
        DeckResponse scr= new Gson().fromJson(response, DeckResponse.class);

        return ResponseHandler.DeckResponseToDeck(scr);
    }

    @Override
    public Deck shuffle(int deckCount) {
        String url = String.format(SHUFFLE_URL, String.valueOf(deckCount));
        String response = restClient.getJSON(url);
        DeckResponse scr= new Gson().fromJson(response, DeckResponse.class);

        return ResponseHandler.DeckResponseToDeck(scr);
    }

    @Override
    public List<Card> drawCards(Deck deck, int cardCount) {
        String url = String.format(DRAW_CARD_URL, deck.getId(), String.valueOf(cardCount));
        String response = restClient.getJSON(url);
        DrawCardResponse dcr = new Gson().fromJson(response, DrawCardResponse.class);

        deck.setRemining(dcr.getRemaining());
        return ResponseHandler.getCards(dcr);
    }

    @Override
    public void reShuffle(Deck deck) {
        String url = String.format(RESHUFFLE_URL, deck.getId());
        restClient.getJSON(url);
    }
}
