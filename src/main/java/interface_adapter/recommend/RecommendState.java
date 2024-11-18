package interface_adapter.recommend;

import java.util.HashMap;
import java.util.Map;

/**
 * The state for the Recommendation View Model.
 */
public class RecommendState {
    private Map<String, String> songRecommendations = new HashMap<String, String>();
    private String recommendationError;

    public RecommendState(RecommendState recommendState) {
        songRecommendations = recommendState.songRecommendations;
        recommendationError = recommendState.recommendationError;
    }

    public Map<String, String> getSongRecommendations() {
        return songRecommendations;
    }

    public String getRecommendationError() {
        return recommendationError;
    }

    public void setSongRecommendations(Map<String, String> songRecommendations) {
        this.songRecommendations = songRecommendations;
    }

    public void setRecommendationError(String recommendationError) {
        this.recommendationError = recommendationError;
    }
}
