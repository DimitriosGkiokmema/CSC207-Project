package use_case.recommend;

import java.util.List;
import java.util.Map;

/**
 * The Input Data for the Recommend Use Case.
 */
public class RecommendInputData {

    private final List<String> songRecommendations;
    private final String topArtists;
    private String accessToken;

    public RecommendInputData(List<String> songRecommendations, String topArtists, String accessToken) {
        this.songRecommendations = songRecommendations;
        this.topArtists = topArtists;
        this.accessToken = accessToken;
    }

    public List<String> getListeningHistory() {
        return songRecommendations;
    }

    public String getTopArtists() {
        return topArtists;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
