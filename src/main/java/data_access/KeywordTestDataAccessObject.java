package data_access;

import use_case.keyword.KeywordDataAccessInterface;
import java.util.ArrayList;
import java.util.List;

public class KeywordTestDataAccessObject implements KeywordDataAccessInterface {

    @Override
    public List<String> searchSongs(String artistName, String keyword) {
        if ("Taylor Swift".equals(artistName) && "Love".equals(keyword)) {
            List<String> results = new ArrayList<>();
            results.add("Love Story");
            return results;
        }
        return new ArrayList<>();
    }
}