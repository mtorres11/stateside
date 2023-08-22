package org.statesidejokes.wrapperapi;

import org.statesidejokes.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

public class DadJokesSync extends DadJokes {

    public DadJokesSync(JSONParser parser) {
        super(parser);
    }
    public DadJokesSync()
    {
        super();
    }

    @Override
    public String getRandomJoke() {
        String response = makeRequest(RANDOM_JOKE_URL);
        return jsonParser.parseRandomJokeResponse(response);
    }

    @Override
    public int getJokeCount() {
        String response = makeRequest(COUNT_JOKES_URL);
        return jsonParser.parseJokeCountResponse(response);
    }

    protected String makeRequest(String endpoint) {
        try {
            URI uri = new URI(BASE_URL + endpoint);
            HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-RapidAPI-Host", "dad-jokes.p.rapidapi.com");
            connection.setRequestProperty("X-RapidAPI-Key", API_KEY);

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }

        } catch (IOException | URISyntaxException e) {
            logger.error("Error making request", e);
            return null;
        }
    }
}
