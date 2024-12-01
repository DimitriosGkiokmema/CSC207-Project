package interface_adapter.recommend;

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
     * @param accessToken the user's spotify access token
     */
    public void execute(String accessToken) {
        final RecommendInputData recommendInputData = new RecommendInputData(accessToken);

        recommendUseCaseInteractor.execute(recommendInputData);
    }
}
