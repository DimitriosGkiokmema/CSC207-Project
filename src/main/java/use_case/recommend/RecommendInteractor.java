package use_case.recommend;

import java.util.Map;

/**
 * The Recommendations Interactor.
 */
public class RecommendInteractor implements RecommendInputBoundary {
    private final RecommendUserDataAcessInterface recommendDataAccessObject;
    private final RecommendOutputBoundary recommendationOutputBoundary;

    public RecommendInteractor(RecommendUserDataAcessInterface recommendDataAccessInterface,
                           RecommendOutputBoundary recommendOutputBoundary) {
        this.recommendDataAccessObject = recommendDataAccessInterface;
        this.recommendationOutputBoundary = recommendOutputBoundary;
    }

    @Override
    public void execute(RecommendInputData recommendInputData) {
        final Map<String, String> songRecommendations = recommendInputData.getRecommendations();
        recommendDataAccessObject.setSongRecommendations(songRecommendations);

        final RecommendOutputData outputData = new RecommendOutputData(songRecommendations, false);
        recommendationOutputBoundary.prepareSuccessView(outputData);
    }
}
