package interface_adapter.recommend;

import java.util.List;

/**
 * The state for the Recommendation View Model.
 */
public class RecommendState {
    private String songRecommendations;
    private String accessToken;
    private List<String> topArtists;

    public RecommendState() {

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
}
