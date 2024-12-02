package use_case.recommend;

import java.util.List;

/**
 * The output data for the Recommend Use Case.
 */
public class RecommendOutputData {
    private final String songRecommendations;
    private final List<String> topArtists;
    private String accessToken;

    public RecommendOutputData(String songRecommendations, List<String> topArtists, String accessToken) {
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

    public List<String> getCurrentTopArtists() {
        return topArtists;
    }
}
