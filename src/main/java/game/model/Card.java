package game.model;

import java.io.Serializable;

/**
 * Created by fred on 9/28/17.
 */
public class Card implements Serializable{
    private static final long serialVersionUID = 12350L;

    private String image;
    private String value;
    private String suit;
    private String code;

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
