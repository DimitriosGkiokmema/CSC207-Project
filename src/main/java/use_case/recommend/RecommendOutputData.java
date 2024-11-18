package use_case.recommend;

import java.util.Map;

/**
 * The output data for the Recommend Use Case.
 */
public class RecommendOutputData {
    private final Map<String, String> songRecommendations;
    private final boolean useCaseFailed;

    public RecommendOutputData(Map<String, String> songRecommendations, boolean useCaseFailed) {
        this.songRecommendations = songRecommendations;
        this.useCaseFailed = useCaseFailed;
    }

    public Map<String, String> getSongRecommendations() {
        return songRecommendations;
    }
}
