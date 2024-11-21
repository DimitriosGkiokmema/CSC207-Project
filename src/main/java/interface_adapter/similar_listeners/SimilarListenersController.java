package interface_adapter.similar_listeners;

import java.util.ArrayList;

import use_case.similar_listeners.SimilarListenersInputBoundary;
import use_case.similar_listeners.SimilarListenersInputData;

/**
 * The controller for SimilarListeners use case.
 */
public class SimilarListenersController {
    private final SimilarListenersInputBoundary similarListenersInputBoundary;

    public SimilarListenersController(SimilarListenersInputBoundary similarListenersUseCaseInteractor) {
        this.similarListenersInputBoundary = similarListenersUseCaseInteractor;
    }

    /**
     * Executes the Login Use Case.
     * @param accessToken the username of the user logging in
     * @param followedArtists the list of artists this user follows.
     */
    public void execute(String accessToken, ArrayList<String> followedArtists) {
        final SimilarListenersInputData similarListenersInputData = new SimilarListenersInputData(accessToken,
                followedArtists);

        similarListenersInputBoundary.execute(similarListenersInputData);
    }
}

