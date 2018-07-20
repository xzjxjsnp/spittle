package spittrtest.service;

import spittrtest.model.Spitter;

import java.io.IOException;

public interface SpitterRepository {
    public void saveSpitter(Spitter spitter) throws IOException;
    public Spitter findUser(String username) throws IOException;
}
