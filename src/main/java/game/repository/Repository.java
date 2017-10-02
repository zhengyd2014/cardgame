package game.repository;

import game.model.CardGame;

/**
 * Created by fred on 10/1/17.
 */
public interface Repository {

    public void save(CardGame game);
    public void remove(CardGame game);

}
