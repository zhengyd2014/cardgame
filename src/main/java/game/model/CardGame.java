package game.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fred on 9/28/17.
 */
public interface CardGame {

    public void init();

    public void play(GameCommand command);

}
