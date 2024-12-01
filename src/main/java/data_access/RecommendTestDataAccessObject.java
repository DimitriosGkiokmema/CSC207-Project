package data_access;

import use_case.recommend.RecommendSpotifyDataAccessInterface;
import use_case.recommend.RecommendUserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class RecommendTestDataAccessObject implements RecommendSpotifyDataAccessInterface,
        RecommendUserDataAccessInterface {
    private List<String> topTracks;
    private String topArtists;

    public RecommendTestDataAccessObject(){
        topTracks = new ArrayList<>();
        topTracks.add("(sic)");
        topTracks.add("Left Behind");
        topTracks.add("Spit It Out");
        topTracks.add("People = Shit");
        topTracks.add("Metabolic");
        topTracks.add("Everything Ends");

        topArtists = "Slipknot, Soulfly, Korn, Sepultura, System Of A Down";
    }

    @Override
    public List<String> getTopTracks() {
        return topTracks;
    }

    @Override
    public void setTopTracks(List<String> topTracks) {
        this.topTracks = topTracks;
    }

    @Override
    public String getTopArtists() {
        return topArtists;
    }

    @Override
    public void setTopArtists(String topArtists) {
        this.topArtists = topArtists;
    }

    @Override
    public String getRecommendations(List<String> songs, String topArtists) {
        return "";
    }
}
