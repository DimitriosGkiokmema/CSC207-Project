package data_access;

import use_case.recommend.RecommendUserDataAccessInterface;
import data_access.LanguageModelDataAccessObject;
import data_access.SpotifyDataAccessObject;

import java.util.ArrayList;
import java.util.List;

public class RecommendUserDataAccessObject implements RecommendUserDataAccessInterface {
    private List<String> topTracks;
    private List<String> topArtists;

    public RecommendUserDataAccessObject() {
        final SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject();
        topTracks = spotifyDataAccessObject.getCurrentTopTracks();
        topArtists = spotifyDataAccessObject.getCurrentTopArtists();
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
    public List<String> getCurrentTopArtists() {
        return topArtists;
    }

    @Override
    public void setCurrentTopArtists(List<String> artists) {
        this.topArtists = artists;
    }

    @Override
    public String getRecommendations(List<String> songs, List<String> topArtists) {
        final LanguageModelDataAccessObject languageModel = new LanguageModelDataAccessObject();
        return languageModel.getRecommendations(songs, topArtists);
    }
}
