package web;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MyHttpClient {
    private final HttpClient client = HttpClient.newHttpClient();
    private final String BASE_URL = String.format("https://v6.exchangerate-api.com/v6/%s/pair", System.getenv("APIKEY"));

    public MyHttpClient() {
    }

    public String sendRequest() throws IOException, InterruptedException {
        HttpRequest request = createRequest();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    private HttpRequest createRequest() {
        return HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s/EUR/GBP", BASE_URL)))
                .build();
    }
}
