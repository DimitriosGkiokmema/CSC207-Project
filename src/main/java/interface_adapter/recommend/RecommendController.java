package interface_adapter.recommend;

import java.util.List;
import java.util.Map;

import use_case.recommend.RecommendInputBoundary;
import use_case.recommend.RecommendInputData;

/**
 * The controller for the Recommend Use Case.
 */
public class RecommendController {
    private final RecommendInputBoundary recommendUseCaseInteractor;

    public RecommendController(RecommendInputBoundary recommendUseCaseInteractor) {
        this.recommendUseCaseInteractor = recommendUseCaseInteractor;
    }

    /**
     * Executes the Recommend Use Case.
     * @param songRecommendations the map of song recommendations in the form of song, artist
     */
    public void execute(List<String> songRecommendations, String topArtists, String accessToken) {
        final RecommendInputData recommendInputData = new RecommendInputData(
                songRecommendations, topArtists, accessToken);

        recommendUseCaseInteractor.execute(recommendInputData);
    }
}
