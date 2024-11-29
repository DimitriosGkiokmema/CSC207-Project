package data_access;

import use_case.recommend.RecommendUserDataAccessInterface;
import data_access.LanguageModelDataAccessObject;

import java.util.ArrayList;
import java.util.List;

public class RecommendUserDataAccessObject implements RecommendUserDataAccessInterface {
    private List<String> topTracks;
    private String topArtists;

    public RecommendUserDataAccessObject() {
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
    public List<String> getCurrentTopTracks() {
        return topTracks;
    }

    @Override
    public void setCurrentTopTracks(List<String> topTracks) {
        this.topTracks = topTracks;
    }

    @Override
    public String getTopArtists() {
        return topArtists;
    }

    @Override
    public void setTopArtists(String artists) {
        this.topArtists = artists;
    }

    @Override
    public String getRecommendations(List<String> songs, String topArtists) {
        final LanguageModelDataAccessObject languageModel = new LanguageModelDataAccessObject();
        return languageModel.getRecommendations(songs, topArtists);
    }
}
