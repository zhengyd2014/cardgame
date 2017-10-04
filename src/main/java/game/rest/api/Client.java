package game.rest.api;

import game.rest.RestClientException;

/**
 * Created by fred on 10/3/17.
 */
public interface Client {

    /**
     * Executes the request and returns the result.
     *
     * @param request
     *            The WebServices request to send to the remote server
     * @return instance of Response
     */
    public Response execute(Request request) throws RestClientException;

}
