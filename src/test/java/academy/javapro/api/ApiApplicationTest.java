package academy.javapro.api;

import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiApplicationTest {

    private static final String BASE =
            "http://localhost:" + System.getProperty("server.port", "8080");

    @Test
    void springContextLoads() throws Exception {
        var client   = HttpClient.newHttpClient();
        var request  = HttpRequest.newBuilder()
                .uri(URI.create(BASE + "/actuator/health"))
                .GET().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("UP"));
    }

    @Test
    void serverResponds() throws Exception {
        var client   = HttpClient.newHttpClient();
        var request  = HttpRequest.newBuilder()
                .uri(URI.create(BASE + "/"))
                .GET().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // No controllers yet — 404 is correct
        assertTrue(response.statusCode() < 500);
    }
}