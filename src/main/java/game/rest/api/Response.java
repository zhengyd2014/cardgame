package game.rest.api;

import java.io.InputStream;

/**
 * Created by fred on 10/3/17.
 */
public interface Response {

    /**
     * Sets the object containing the response content.
     *
     * @param content
     *            The object containing the response content.
     */
    public void setContent(String content) ;

    /**
     * Gets the object containing the response content.
     *
     */
    public String getContent() ;

    /**
     * Sets the HTTP status text returned with this response.
     *
     * @param statusText
     *            The HTTP status text (ex: "Not found") returned with this
     *            response.
     */
    public void setStatusText(String statusText) ;

    /**
     * Gets the HTTP status text associated with this response.
     *
     */
    public String getStatusText() ;

    /**
     * Sets the HTTP status code that was returned with this response.
     *
     * @param statusCode
     *            The HTTP status code (ex: 200, 404, etc) associated with this
     *            response.
     */
    public void setStatusCode(int statusCode) ;

    /**
     * Gets the HTTP status code (ex: 200, 404) associated with this response.
     *
     */
    public int getStatusCode();

}
