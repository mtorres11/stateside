package org.statesidejokes.wrapperapi;


import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;
import org.asynchttpclient.Request;
import org.asynchttpclient.Response;
import org.statesidejokes.parser.JSONParser;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * This class has been returned the following response from the server:
 * {"message":"Too many requests"}
 */
public class DadJokesAsync extends DadJokes {

    private final AsyncHttpClient asyncHttpClient;

    public DadJokesAsync(JSONParser parser) {
        super(parser);
        asyncHttpClient = Dsl.asyncHttpClient();
    }

    public DadJokesAsync() {
        super();
        asyncHttpClient = Dsl.asyncHttpClient();
    }

    @Override
    public String getRandomJoke() {
        Request request = Dsl.get(BASE_URL + RANDOM_JOKE_URL)
                .addHeader("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", API_KEY)
                .build();

        Future<Response> future = asyncHttpClient.executeRequest(request);
        try {
            Response response = future.get();
            String jsonResponse = response.getResponseBody();
            return jsonParser.parseRandomJokeResponse(jsonResponse);
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Error fetching random joke", e);
            throw new RuntimeException("Error fetching random joke", e);
        }
    }

    @Override
    public int getJokeCount() {
        Request request = Dsl.get(BASE_URL + COUNT_JOKES_URL)
                .addHeader("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com")
                .addHeader("X-RapidAPI-Key", API_KEY)
                .build();

        Future<Response> future = asyncHttpClient.executeRequest(request);
        try {
            Response response = future.get();
            String jsonResponse = response.getResponseBody();
            return jsonParser.parseJokeCountResponse(jsonResponse);
        } catch (InterruptedException | ExecutionException e) {
            logger.error("Error fetching joke count", e);
            throw new RuntimeException("Error fetching joke count", e);
        }
    }

    public void close() throws IOException {
        asyncHttpClient.close();
    }
}
