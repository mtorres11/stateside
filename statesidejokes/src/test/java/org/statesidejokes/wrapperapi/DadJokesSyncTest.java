package org.statesidejokes.wrapperapi;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.statesidejokes.parser.JSONParser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class DadJokesSyncTest {

    @Test
    public void testGetRandomJoke_SuccessfulResponse() {
        JSONParser jsonParserMock = Mockito.mock(JSONParser.class);
        when(jsonParserMock.parseRandomJokeResponse(Mockito.anyString())).thenReturn("Mocked Joke");

        DadJokesSync dadJokesSync = new DadJokesSync(jsonParserMock);

        String joke = dadJokesSync.getRandomJoke();
        assertEquals("Mocked Joke", joke);
    }
}
