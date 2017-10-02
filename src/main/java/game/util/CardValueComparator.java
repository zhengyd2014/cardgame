package game.util;

/**
 * Created by fred on 10/1/17.
 */
public class CardValueComparator<String> implements java.util.Comparator {
    @Override
    public int compare(Object v1, Object v2) {
        return getIntValue(v1.toString()) - getIntValue(v2.toString());
    }

    private int getIntValue(java.lang.String cardValue) {
        if (cardValue.startsWith("A")) {  // Ace
            return 1;
        } else if (cardValue.startsWith("0")) {
            return 10;
        } else if (cardValue.startsWith("J")) {
            return 11;
        } else if (cardValue.startsWith("Q")) {
            return 12;
        } else if (cardValue.startsWith("K")) {
            return 13;
        } else {
            return Integer.parseInt(cardValue);
        }
    }
}
