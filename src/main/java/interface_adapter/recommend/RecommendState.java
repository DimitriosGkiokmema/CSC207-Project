package interface_adapter.recommend;

/**
 * The state for the Recommendation View Model.
 */
public class RecommendState {
    private String accessToken = "";

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
