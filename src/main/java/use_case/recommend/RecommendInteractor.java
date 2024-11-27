package use_case.recommend;

import java.util.List;
import java.util.Map;

/**
 * The Recommendations Interactor.
 */
public class RecommendInteractor implements RecommendInputBoundary {
    private final RecommendLanguageModelDataAccessInterface recommendDataAccessObject;
    private final RecommendSpotifyDataAccessInterface spotifyDataAccessObject;
    private final RecommendOutputBoundary recommendationOutputBoundary;

    public RecommendInteractor(RecommendLanguageModelDataAccessInterface recommendDataAccessInterface,
                               RecommendSpotifyDataAccessInterface spotifyDataAccessObject,
                               RecommendOutputBoundary recommendOutputBoundary) {
        this.recommendDataAccessObject = recommendDataAccessInterface;
        this.spotifyDataAccessObject = spotifyDataAccessObject;
        this.recommendationOutputBoundary = recommendOutputBoundary;
    }

    @Override
    public void execute(RecommendInputData recommendInputData) {
        // Calls Spotify API to get user data
        final List<String> songs = spotifyDataAccessObject.getCurrentTopTracks();
        // Takes user data and asks Azure for recommendations
        final String songRecommendations = recommendDataAccessObject.getRecommendations(songs);
        // Gets access token
        final String accessToken = recommendInputData.getAccessToken();

        final RecommendOutputData outputData = new RecommendOutputData(songRecommendations, accessToken);
        recommendationOutputBoundary.prepareSuccessView(outputData);
    }
}
