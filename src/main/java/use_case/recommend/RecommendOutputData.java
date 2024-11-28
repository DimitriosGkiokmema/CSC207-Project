package use_case.recommend;

/**
 * The output data for the Recommend Use Case.
 */
public class RecommendOutputData {
    private final String songRecommendations;
    private final String topArtists;
    private String accessToken;

    public RecommendOutputData(String songRecommendations, String topArtists, String accessToken) {
        this.songRecommendations = songRecommendations;
        this.topArtists = topArtists;
        this.accessToken = accessToken;
    }

    public String getSongRecommendations() {
        return songRecommendations;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTopArtists() {
        return topArtists;
    }
}
