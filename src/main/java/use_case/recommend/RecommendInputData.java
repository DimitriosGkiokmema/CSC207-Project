package use_case.recommend;

import java.util.Map;

/**
 * The Input Data for the Recommend Use Case.
 */
public class RecommendInputData {

    private final Map<String, String> songRecommendations;

    public RecommendInputData(Map<String, String> songRecommendations) {
        this.songRecommendations = songRecommendations;
    }

    public Map<String, String> getRecommendations() {
        return songRecommendations;
    }
}
