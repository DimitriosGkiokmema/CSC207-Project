package data_access;

import use_case.recommend.RecommendUserDataAccessInterface;
import data_access.LanguageModelDataAccessObject;
import data_access.SpotifyDataAccessObject;

import java.util.ArrayList;
import java.util.List;

public class RecommendUserDataAccessObject implements RecommendUserDataAccessInterface {
    private List<String> topTracks;
    private String topArtists;

    public RecommendUserDataAccessObject() {
        final SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject();
        topTracks = spotifyDataAccessObject.getCurrentTopTracks();
        topArtists = spotifyDataAccessObject.getTopArtists();
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
    public void setTopArtists(String artists) {
        this.topArtists = artists;
    }

    @Override
    public String getRecommendations(List<String> songs, String topArtists) {
        final LanguageModelDataAccessObject languageModel = new LanguageModelDataAccessObject();
        return languageModel.getRecommendations(songs, topArtists);
    }
}
