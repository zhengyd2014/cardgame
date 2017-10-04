package game.rest.impl.httpurlconnection;

import game.rest.api.Response;

import java.io.InputStream;

/**
 * Created by fred on 10/3/17.
 */
public class HttpConnectionResponse implements Response {

    private String content;
    private String statusText;
    private int statusCode;

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setStatusText(String statusText) {
        this.statusText = statusText;
    }

    @Override
    public String getStatusText() {
        return statusText;
    }

    @Override
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public int getStatusCode() {
        return statusCode;
    }
}
