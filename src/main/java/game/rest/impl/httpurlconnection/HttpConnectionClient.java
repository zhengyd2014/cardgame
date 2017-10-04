package game.rest.impl.httpurlconnection;

import game.rest.RestClientException;
import game.rest.api.Client;
import game.rest.api.HttpMethodName;
import game.rest.api.Request;
import game.rest.api.Response;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fred on 10/3/17.
 */
public class HttpConnectionClient implements Client{

    private int connectionTimeout = 3000;

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    @Override
    public Response execute(Request request) throws RestClientException {
        HttpMethodName method = request.getHttpMethod();
        String url = request.getUrl();
        switch (method) {
            case GET:
                return get(url);
            case DELETE:
            case HEAD:
            case POST:
            case PUT:
            case OPTIONS:
            default:
                System.out.println("unsupport method");
        }

        return null;
    }

    private Response get(String url) {
        HttpConnectionResponse response = new HttpConnectionResponse();
        HttpsURLConnection conn = null;
        try {
            conn = (HttpsURLConnection)new URL(url).openConnection();
            conn.addRequestProperty("User-Agent", "Mozilla/4.76");
            conn.setConnectTimeout(connectionTimeout);
            conn.connect();

            response.setStatusCode(conn.getResponseCode());
            response.setStatusText((conn.getResponseMessage()));
            response.setContent(readResponse(conn.getInputStream()));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception ex) {
                    Logger.getLogger(HttpConnectionClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return response;
    }

    private String readResponse(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        return sb.toString();
    }


}
