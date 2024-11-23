package interface_adapter.recommend;

/**
 * The state for the Recommendation View Model.
 */
public class RecommendState {
    private String songRecommendations;

    public RecommendState(RecommendState recommendState) {
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public RecommendState() {

    }

    public void setSongRecommendations(String songRecommendations) {
        this.songRecommendations = songRecommendations;
    }

    public String getSongRecommendations() {
        return songRecommendations;
    }
}
