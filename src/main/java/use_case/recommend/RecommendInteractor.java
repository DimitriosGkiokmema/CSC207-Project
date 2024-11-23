package use_case.recommend;

import java.util.Map;

/**
 * The Recommendations Interactor.
 */
public class RecommendInteractor implements RecommendInputBoundary {
    private final RecommendLanguageModelDataAccessInterface recommendDataAccessObject;
    private final RecommendOutputBoundary recommendationOutputBoundary;

    public RecommendInteractor(RecommendLanguageModelDataAccessInterface recommendDataAccessInterface,
                           RecommendOutputBoundary recommendOutputBoundary) {
        this.recommendDataAccessObject = recommendDataAccessInterface;
        this.recommendationOutputBoundary = recommendOutputBoundary;
    }

    @Override
    public void execute(RecommendInputData recommendInputData) {
        final Map<String, String> history = recommendInputData.getListeningHistory();
        final String songRecommendations = recommendDataAccessObject.getRecommendations(history);

        final RecommendOutputData outputData = new RecommendOutputData(songRecommendations);
        recommendationOutputBoundary.prepareSuccessView(outputData);
    }
}
