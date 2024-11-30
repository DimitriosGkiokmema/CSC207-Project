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
     * @param topTracks the list of songs listened to by the user.
     * @param topArtists the list of artists listened to by the user
     * @param accessToken the user's spotify access token
     */
    public void execute(List<String> topTracks, List<String> topArtists, String accessToken) {
        final RecommendInputData recommendInputData = new RecommendInputData(
                topTracks, topArtists, accessToken);

        recommendUseCaseInteractor.execute(recommendInputData);
    }
}
