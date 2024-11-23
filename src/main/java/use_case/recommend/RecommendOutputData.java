package use_case.recommend;

/**
 * The output data for the Recommend Use Case.
 */
public class RecommendOutputData {
    private final String songRecommendations;

    public RecommendOutputData(String songRecommendations) {
        this.songRecommendations = songRecommendations;
    }

    public String getSongRecommendations() {
        return songRecommendations;
    }
}
