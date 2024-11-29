package use_case.recommend;

import java.util.List;

/**
 * The Recommendations Interactor.
 */
public class RecommendInteractor implements RecommendInputBoundary {
    private final RecommendUserDataAccessInterface userDataAccessObject;
    private final RecommendOutputBoundary recommendationOutputBoundary;

    public RecommendInteractor(RecommendUserDataAccessInterface userDataAccessObject,
                               RecommendOutputBoundary recommendOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.recommendationOutputBoundary = recommendOutputBoundary;
    }

    @Override
    public void execute(RecommendInputData recommendInputData) {
        // Calls Spotify API to get user data
        final List<String> topTracks = userDataAccessObject.getTopTracks();
        userDataAccessObject.setTopTracks(topTracks);
        final String topArtists = userDataAccessObject.getTopArtists();
        userDataAccessObject.setTopArtists(topArtists);
        // Takes user data and asks Azure for recommendations
        System.out.printf("Calling spotify api with songs: " + topTracks);
        final String songRecommendations = userDataAccessObject.getRecommendations(topTracks, topArtists);
        // Gets spotify access token
        final String accessToken = recommendInputData.getAccessToken();

        final RecommendOutputData outputData = new RecommendOutputData(songRecommendations, topArtists, accessToken);
        if (songRecommendations.contains("Error")) {
            recommendationOutputBoundary.prepareFailView(songRecommendations);
        }
        else {
            recommendationOutputBoundary.prepareSuccessView(outputData);
        }
    }
}
