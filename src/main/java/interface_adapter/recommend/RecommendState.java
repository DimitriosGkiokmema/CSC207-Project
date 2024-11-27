package interface_adapter.recommend;

/**
 * The state for the Recommendation View Model.
 */
public class RecommendState {
    private String songRecommendations;
    private String accessToken;

    // Because of the previous copy constructor, the default constructor must be explicit.
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
}
