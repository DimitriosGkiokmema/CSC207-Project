package data_access;

import java.util.ArrayList;
import java.util.List;

import use_case.recommend.RecommendDataAccessInterface;
import use_case.recommend.RecommendLanguageModelDataAccessInterface;

/**
 * Test spotify DAO for the recommendations use case
 */
public class RecommendTestDataAccessObject implements RecommendDataAccessInterface,
        RecommendLanguageModelDataAccessInterface {
    private List<String> topTracks;
    private List<String> topArtists;

    public RecommendTestDataAccessObject() {
        topTracks = new ArrayList<>();
        topTracks.add("(sic)");
        topTracks.add("Left Behind");
        topTracks.add("Spit It Out");
        topTracks.add("People = Shit");
        topTracks.add("Metabolic");
        topTracks.add("Everything Ends");

        topArtists = new ArrayList<>();
        topArtists.add("Slipknot");
        topArtists.add("Soulfly");
        topArtists.add("Korn");
        topArtists.add("(Sepultura)");
        topArtists.add("System Of A Down");
    }

    @Override
    public List<String> getCurrentTopTracks() {
        return topTracks;
    }

    @Override
    public void setCurrentTopTracks(List<String> tracks) {
        this.topTracks = tracks;
    }

    @Override
    public List<String> getCurrentTopArtists() {
        return topArtists;
    }

    @Override
    public void setCurrentTopArtists(List<String> artists) {
        this.topArtists = artists;
    }

    @Override
    public String getRecommendations(List<String> prompt, List<String> artists) {
        return "This is a sample response from Azure";
    }
}
