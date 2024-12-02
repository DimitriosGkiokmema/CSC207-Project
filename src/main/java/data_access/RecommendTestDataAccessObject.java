package data_access;

import use_case.recommend.RecommendDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class RecommendTestDataAccessObject implements RecommendDataAccessInterface {
    private List<String> topTracks;
    private List<String> topArtists;

    public RecommendTestDataAccessObject(){
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
    public List<String> getCurrentTopTracks2() {
        return topTracks;
    }

    @Override
    public void setCurrentTopTracks2(List<String> topTracks) {
        this.topTracks = topTracks;
    }

    @Override
    public List<String> getCurrentTopArtists2() {
        return topArtists;
    }

    @Override
    public void setCurrentTopArtists2(List<String> topArtists) {
        this.topArtists = topArtists;
    }

    @Override
    public void setAccessToken(String accessToken) {
    }
}
