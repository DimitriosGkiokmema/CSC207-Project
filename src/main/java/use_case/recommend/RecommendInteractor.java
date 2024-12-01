package use_case.recommend;

import org.jetbrains.annotations.NotNull;

import javax.management.StringValueExp;
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
        final List<String> topTracks = userDataAccessObject.getCurrentTopTracks();
        final List<String> topArtists = userDataAccessObject.getCurrentTopArtists();
        // Takes user data and asks Azure for recommendations
//        System.out.println("Calling spotify api with songs: " + topTracks);
        final String songRecommendations = userDataAccessObject.getRecommendations(topTracks, topArtists);
        // Gets spotify access token
        final String accessToken = recommendInputData.getAccessToken();
        System.out.println("Access Token in interactor: " + accessToken);

        if (topTracks.isEmpty() || topArtists.isEmpty() || songRecommendations.contains("Error")) {
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
