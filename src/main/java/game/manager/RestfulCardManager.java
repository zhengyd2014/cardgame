package game.manager;

import com.google.gson.Gson;
import game.model.Card;
import game.model.Deck;
import game.response.DrawCardResponse;
import game.response.DeckResponse;
import game.rest.api.Client;
import game.rest.api.HttpMethodName;
import game.rest.impl.httpurlconnection.HttpConnectionRequest;
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


    private Client restClient;

    public RestfulCardManager(Client client) {
        this.restClient = client;
    }

    @Override
    public Deck newDeck() {
        HttpConnectionRequest request = new HttpConnectionRequest();
        request.setHttpMethod(HttpMethodName.GET);
        request.setUrl(NEW_DECK_URL);
        String response = restClient.execute(request).getContent();
        DeckResponse scr= new Gson().fromJson(response, DeckResponse.class);

        return ResponseHandler.DeckResponseToDeck(scr);
    }

    @Override
    public Deck shuffle(int deckCount) {
        String url = String.format(SHUFFLE_URL, String.valueOf(deckCount));
        HttpConnectionRequest request = new HttpConnectionRequest();
        request.setHttpMethod(HttpMethodName.GET);
        request.setUrl(url);
        String response = restClient.execute(request).getContent();
        DeckResponse scr= new Gson().fromJson(response, DeckResponse.class);

        return ResponseHandler.DeckResponseToDeck(scr);
    }

    @Override
    public List<Card> drawCards(Deck deck, int cardCount) {
        String url = String.format(DRAW_CARD_URL, deck.getId(), String.valueOf(cardCount));
        HttpConnectionRequest request = new HttpConnectionRequest();
        request.setHttpMethod(HttpMethodName.GET);
        request.setUrl(url);
        String response = restClient.execute(request).getContent();
        DrawCardResponse dcr = new Gson().fromJson(response, DrawCardResponse.class);

        deck.setRemining(dcr.getRemaining());
        return ResponseHandler.getCards(dcr);
    }

    @Override
    public void reShuffle(Deck deck) {
        String url = String.format(RESHUFFLE_URL, deck.getId());
        HttpConnectionRequest request = new HttpConnectionRequest();
        request.setHttpMethod(HttpMethodName.GET);
        request.setUrl(url);
        restClient.execute(request).getContent();
    }
}
