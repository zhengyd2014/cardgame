package game.model;

import java.io.Serializable;

/**
 * Created by fred on 9/22/17.
 */
public class Deck implements Serializable{
    private static final long serialVersionUID = 12347L;

    private String id;
    private int remining;

    public int getRemining() {
        return remining;
    }

    public void setRemining(int remining) {
        this.remining = remining;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeckBriefInfo() {
        return "{ID: " + id + ", Remaining: " + remining + "}";
    }
}
