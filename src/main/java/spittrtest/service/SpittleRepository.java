package spittrtest.service;

import spittrtest.model.Spittle;

import java.io.IOException;
import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittle(int count) throws IOException;
}
