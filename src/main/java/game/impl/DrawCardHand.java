package game.impl;

import game.model.Card;
import game.model.Hand;
import game.response.DrawCardResponse;

import java.io.Serializable;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fred on 10/1/17.
 */
public class DrawCardHand extends Hand implements Serializable {

    private static final long serialVersionUID = 12346L;

    Map<String, Integer> cardMap;

    public DrawCardHand(String name) {
        super(name);
        cardMap = new HashMap<>();
    }

    public Map<String, Integer> getCardMap() {
        return cardMap;
    }

    @Override
    public void addCards(List<Card> cardList) {
        super.addCards(cardList);
        for (Card card : cardList) {
            if (cardMap.containsKey(card.getValue())) {
                cardMap.put(card.getValue(), cardMap.get(card.getValue()) + 1);
            } else {
                cardMap.put(card.getValue(), 1);
            }
        }
    }
}

