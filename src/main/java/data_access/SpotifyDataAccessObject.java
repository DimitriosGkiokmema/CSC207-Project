package data_access;

import java.util.HashMap;
import java.util.Map;

import use_case.recommend.RecommendSpotifyDataAccessInterface;

/**
 * Test DAO for spotify
 */
public class SpotifyDataAccessObject implements RecommendSpotifyDataAccessInterface {
    private Map<String, String> songs;

    public SpotifyDataAccessObject() {
        songs = new HashMap<>();
        songs.put("(sic)", "Slipknot");
        songs.put("Left Behind", "Slipknot");
        songs.put("Jumpdafuckup", "Soulfly");
        songs.put("Roots Bloody Roots", "Sepultura");
        songs.put("Dragula", "Rob Zombie");
        songs.put("Spit It Out", "Slipknot");
    }

    @Override
    public Map<String, String> getHistory() {
        return songs;
    }

    public static void main(String[] args) {
        SpotifyDataAccessObject spotify = new SpotifyDataAccessObject();
        System.out.println(spotify.getHistory());
    }
}
