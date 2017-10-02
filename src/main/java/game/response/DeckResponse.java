package game.response;

/**
 * Created by fred on 9/22/17.
 */
public class DeckResponse {

    private boolean success;
    private String deck_id;
    private boolean shuffled;
    private int remaining;

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public boolean isShuffled() {
        return shuffled;
    }

    public void setShuffled(boolean shuffled) {
        this.shuffled = shuffled;
    }

    public String getDeckId() {
        return deck_id;
    }

    public void setDeckId(String deck_id) {
        this.deck_id = deck_id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[success:").append(success).append(", ")
                .append("deck_id:").append(deck_id).append(", ")
                .append("shuffled:").append(shuffled).append(", ")
                .append("remaining:").append(remaining).append("]");
        return sb.toString();
    }

}
