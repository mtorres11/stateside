package org.statesidejokes.wrapperapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.statesidejokes.parser.JSONParser;

public abstract class DadJokes {

    protected static final Logger logger = LoggerFactory.getLogger(DadJokes.class);
    protected static final String BASE_URL = "https://dad-jokes.p.rapidapi.com/";
    protected static final String RANDOM_JOKE_URL = "random/joke";
    protected static final String COUNT_JOKES_URL = "joke/count";
    protected static final String API_KEY = "479d27064emshc531da2ecb0c5b7p1827a2jsnc864c0abe0c4";
    protected final JSONParser jsonParser;

    public DadJokes(JSONParser parser)
    {
        jsonParser = parser;
    }
    public DadJokes()
    {
        jsonParser = new JSONParser();
    }

    public abstract String getRandomJoke();

    public abstract int getJokeCount();
}
