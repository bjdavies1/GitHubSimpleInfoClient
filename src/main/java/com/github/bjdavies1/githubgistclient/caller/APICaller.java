package com.github.bjdavies1.githubgistclient.caller;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class APICaller {
    public APICaller() {
        this.client = HttpClient.newHttpClient();
    }

    private HttpClient client;
    private URI uri;
    private String baseURL = "https://api.github.com";

    public HttpResponse<String> doGet() throws Exception {
        // the default builder http method is GET so calling
        // .GET() on the builder is not necessary
        var headers = new ArrayList<String>() {{
            add("Accept");
            add("application/json");
        }};
        // send() is a blocking synchronous call
        var request = HttpRequest.newBuilder(uri)
                .GET()
                .headers(headers.toArray(new String[0]))
                .build();
        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void setURI(String path) {
        this.uri = URI.create(baseURL + "/" + path);
    }
}
