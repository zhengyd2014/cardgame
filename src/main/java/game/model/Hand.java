package game.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fred on 9/28/17.
 */
public class Hand implements Serializable {

    private static final long serialVersionUID = 12349L;

    private String name;
    private List<Card> cardsInHand;

    public Hand() {};

    public Hand(String name) {
        this.name = name;
        cardsInHand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCardsInHand() {
        return cardsInHand;
    }

    public void addCards(List<Card> cards) {
        cardsInHand.addAll(cards);
    }
}
