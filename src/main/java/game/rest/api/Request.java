package game.rest.api;

/**
 * Created by fred on 10/3/17.
 */
public interface Request {


    public void setHttpMethod(HttpMethodName method);

    public HttpMethodName getHttpMethod();

    public void setUrl(String url);

    public String getUrl();
}
