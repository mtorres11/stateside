package org.statesidejokes.parser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JSONParser {
    private static final Logger logger = LoggerFactory.getLogger(JSONParser.class);

    public int parseJokeCountResponse(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            if (jsonObject.getBoolean("success")) {
                return jsonObject.getInt("body");
            } else {
                logger.error("Failed to fetch joke count");
                throw new RuntimeException("Failed to fetch joke count");
            }
        } catch (JSONException e) {
            logger.error("Failed to parse JSON response", e);
            throw new RuntimeException("Failed to parse JSON response", e);
        }
    }

    public String parseRandomJokeResponse(String jsonResponse) {
        try {
            JSONObject jsonObject = new JSONObject(jsonResponse);
            if (jsonObject.getBoolean("success")) {
                JSONArray jokesArray = jsonObject.getJSONArray("body");
                if (!jokesArray.isEmpty()) {
                    JSONObject jokeObject = jokesArray.getJSONObject(0);
                    return jokeObject.getString("setup") + " " + jokeObject.getString("punchline");
                } else {
                    logger.error("No jokes found in the response");
                    throw new RuntimeException("No jokes found in the response");
                }
            } else {
                logger.error("Failed to fetch random joke");
                throw new RuntimeException("Failed to fetch random joke");
            }
        } catch (JSONException e) {
            logger.error("Failed to parse JSON response", e);
            throw new RuntimeException("Failed to parse JSON response", e);
        }
    }
}
