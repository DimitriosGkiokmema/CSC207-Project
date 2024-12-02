package use_case.recommend;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The Recommendations Interactor.
 */
public class RecommendInteractor implements RecommendInputBoundary {
    private RecommendDataAccessInterface userDataAccessObject;
    private RecommendLanguageModelDataAccessInterface languageModelDataAccessObject;
    private final RecommendOutputBoundary recommendationOutputBoundary;

    public RecommendInteractor(RecommendDataAccessInterface userDataAccessObject,
                               RecommendLanguageModelDataAccessInterface languageModelDataAccessObject,
                               RecommendOutputBoundary recommendOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.languageModelDataAccessObject = languageModelDataAccessObject;
        this.recommendationOutputBoundary = recommendOutputBoundary;
    }

    @Override
    public void execute(RecommendInputData recommendInputData) {
        // Calls Spotify API to get user data
        final List<String> topTracks = userDataAccessObject.getCurrentTopTracks();
        final List<String> topArtists = userDataAccessObject.getCurrentTopArtists();
        // Takes user data and asks Azure for recommendations
        final String songRecommendations = languageModelDataAccessObject.getRecommendations(topTracks, topArtists);
        // Gets spotify access token
        final String accessToken = recommendInputData.getAccessToken();

        if (topTracks == null) {
            recommendationOutputBoundary.prepareFailView("Error: spotify returns empty track list");
        }
        else if (topArtists == null) {
            recommendationOutputBoundary.prepareFailView("Error: spotify returns empty artist list");
        }
        else if (topTracks.isEmpty() || topArtists.isEmpty() || songRecommendations.contains("Error")) {
            StringBuilder errorMsg = getErrorMsg(topTracks, topArtists, songRecommendations);
            recommendationOutputBoundary.prepareFailView(errorMsg.toString());
        }
        else {
            final RecommendOutputData outputData = new RecommendOutputData(songRecommendations, topArtists, accessToken);
            recommendationOutputBoundary.prepareSuccessView(outputData);
        }
    }

    @NotNull
    private static StringBuilder getErrorMsg(List<String> topTracks, List<String> topArtists, String songRecommendations) {
        StringBuilder errorMsg = new StringBuilder("Error: ");
        if (topTracks.isEmpty()) {
            errorMsg.append("song tracks, ");
        }
        if (topArtists.isEmpty()) {
            errorMsg.append("song artists, ");
        }
        if (songRecommendations.contains("Error")) {
            errorMsg.append("song recommendations, ");
        }
        // Deletes ", " from end of string
        errorMsg.delete(errorMsg.length() - 2, errorMsg.length());

        errorMsg.append(" are not available.");

        return errorMsg;
    }
}
