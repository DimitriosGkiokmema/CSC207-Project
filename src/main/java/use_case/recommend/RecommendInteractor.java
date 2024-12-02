package use_case.recommend;

import data_access.LanguageModelDataAccessObject;
import data_access.SpotifyDataAccessObject;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The Recommendations Interactor.
 */
public class RecommendInteractor implements RecommendInputBoundary {
    private RecommendDataAccessInterface userDataAccessObject;
    private LanguageModelDataAccessObject languageModelDataAccessObject;
    private final RecommendOutputBoundary recommendationOutputBoundary;

    public RecommendInteractor(RecommendDataAccessInterface userDataAccessObject,
                               LanguageModelDataAccessObject languageModelDataAccessObject,
                               RecommendOutputBoundary recommendOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.languageModelDataAccessObject = languageModelDataAccessObject;
        this.recommendationOutputBoundary = recommendOutputBoundary;
    }

    @Override
    public void execute(RecommendInputData recommendInputData) {
        // Calls Spotify API to get user data
        //userDataAccessObject = new SpotifyDataAccessObject("BQAU6VReKznwuhEObC_4OfxnZ4Mkmwf8iGF5mN8ryXiD7BXSsFO9UUN9kHt8Z-po9UOzCbX6BFxEfAJgENqnleqOYpwJPRPlE-Z09CcwudNzpwG2Kvh092u15fnBf5pc3bIRjJMMf8KJMiirKf4_TipGZmvXjCV8NpahMZV6AhW5Hw7OtU64ASKjAOD_DeWhqQ7hndqY4Ds25qRp2MrkK2cf__8");
        final List<String> topTracks = userDataAccessObject.getCurrentTopTracks2();
        final List<String> topArtists = userDataAccessObject.getCurrentTopArtists2();
        System.out.println("Rec interface: " + topTracks);
        // Takes user data and asks Azure for recommendations
//        System.out.println("Calling spotify api with songs: " + topTracks);
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
