package use_case.recommend;

import java.util.Map;

/**
 * The Input Data for the Recommend Use Case.
 */
public class RecommendInputData {

    private final Map<String, String> songRecommendations;
    private String accessToken;

    public RecommendInputData(Map<String, String> songRecommendations, String accessToken) {
        this.songRecommendations = songRecommendations;
        this.accessToken = accessToken;
    }

    public Map<String, String> getListeningHistory() {
        return songRecommendations;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
