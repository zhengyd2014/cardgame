package game.rest.impl.httpurlconnection;

import game.rest.api.HttpMethodName;
import game.rest.api.Request;

/**
 * Created by fred on 10/3/17.
 */
public class HttpConnectionRequest implements Request {

    HttpMethodName method;
    String url;

    @Override
    public void setHttpMethod(HttpMethodName method) {
        this.method = method;
    }

    @Override
    public HttpMethodName getHttpMethod() {
        return method;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
