package org.statesidejokes.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JSONParserTest {

    @Test
    public void testParseJokeCountResponse_SuccessfulResponse() {
        JSONParser jsonParser = new JSONParser();

        String jsonResponse = "{\"success\": true, \"body\": 123}";
        int jokeCount = jsonParser.parseJokeCountResponse(jsonResponse);
        Assertions.assertEquals(123, jokeCount);
    }

    @Test
    public void testParseJokeCountResponse_FailedResponse() {
        JSONParser jsonParser = new JSONParser();

        String jsonResponse = "{\"success\": false, \"error\": \"An error occurred\"}";

        Assertions.assertThrows(RuntimeException.class, () -> jsonParser.parseJokeCountResponse(jsonResponse));
    }

    @Test
    public void testParseJokeCountResponse_InvalidJson() {
        JSONParser jsonParser = new JSONParser();

        String invalidJsonResponse = "Invalid JSON";

        Assertions.assertThrows(RuntimeException.class, () -> jsonParser.parseJokeCountResponse(invalidJsonResponse));
    }

    @Test
    public void testParseRandomJokeResponse_SuccessfulResponse() {
        JSONParser jsonParser = new JSONParser();

        String jsonResponse = "{\"success\": true, \"body\": [{\"setup\": \"Test setup\", \"punchline\": \"Test punchline\"}]}";
        String joke = jsonParser.parseRandomJokeResponse(jsonResponse);
        Assertions.assertEquals("Test setup Test punchline", joke);
    }

    @Test
    public void testParseRandomJokeResponse_EmptyJokesArray() {
        JSONParser jsonParser = new JSONParser();

        String jsonResponse = "{\"success\": true, \"body\": []}";

        Assertions.assertThrows(RuntimeException.class, () -> jsonParser.parseRandomJokeResponse(jsonResponse));
    }

    @Test
    public void testParseRandomJokeResponse_FailedResponse() {
        JSONParser jsonParser = new JSONParser();

        String jsonResponse = "{\"success\": false, \"error\": \"An error occurred\"}";

        Assertions.assertThrows(RuntimeException.class, () -> jsonParser.parseRandomJokeResponse(jsonResponse));
    }

    @Test
    public void testParseRandomJokeResponse_InvalidJson() {
        JSONParser jsonParser = new JSONParser();

        String invalidJsonResponse = "Invalid JSON";

        Assertions.assertThrows(RuntimeException.class, () -> jsonParser.parseRandomJokeResponse(invalidJsonResponse));
    }
}
