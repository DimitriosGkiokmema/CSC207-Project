package interface_adapter.recommend;

/**
 * The state for the Recommendation View Model.
 */
public class RecommendState {
    private String songRecommendations;
    private String recommendationError;

    public RecommendState(RecommendState recommendState) {
        songRecommendations = recommendState.songRecommendations;
        recommendationError = recommendState.recommendationError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public RecommendState() {

    }

    public String getSongRecommendations() {
        return songRecommendations;
    }

    public String getRecommendationError() {
        return recommendationError;
    }

    public void setSongRecommendations(String songRecommendations) {
        this.songRecommendations = songRecommendations;
    }

    public void setRecommendationError(String recommendationError) {
        this.recommendationError = recommendationError;
    }
}
