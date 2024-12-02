package interface_adapter.recommend;

import java.util.List;

/**
 * The state for the Recommendation View Model.
 */
public class RecommendState {
    private String songRecommendations;
    private List<String> topArtists;
    private List<String> topTracks;
    private String accessToken;
    private String artistsError;
    private String tracksError;

    public RecommendState() {

    }

    public List<String> getTracks() {
        return topTracks;
    }

    public String getTracksError() {
        return tracksError;
    }

    public void setTracks(List<String> topTracks) {
        this.topTracks = topTracks;
    }

    public void setTracksError(String tracksError) {
        this.tracksError = tracksError;
    }

    public void setSongRecommendations(String songRecommendations) {
        this.songRecommendations = songRecommendations;
    }

    public String getSongRecommendations() {
        return songRecommendations;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setTopArtists(List<String> topArtists) {
        this.topArtists = topArtists;
    }

    public List<String> getTopArtists() {
        return topArtists;
    }

    public void setArtistsError(String artistsError) {
        this.artistsError = artistsError;
    }

}
