package game.rest;

/**
 * Created by fred on 10/3/17.
 */
public class RestClientException extends RuntimeException {
    /**
     * Creates a new AmazonClientException with the specified message, and root
     * cause.
     *
     * @param message
     *            An error message describing why this exception was thrown.
     * @param t
     *            The underlying cause of this exception.
     */
    public RestClientException(String message, Throwable t) {
        super(message, t);
    }

    /**
     * Creates a new AmazonClientException with the specified message.
     *
     * @param message
     *            An error message describing why this exception was thrown.
     */
    public RestClientException(String message) {
        super(message);
    }
}
