package use_case.similar_listeners;

import java.util.List;

/**
 * SimilarListeners Interactor.
 */
public class SimilarListenersInteractor implements SimilarListenersInputBoundary {
    private final SimilarListenersUserDataAccessInterface userDataAccessObject;
    private final SimilarListenersOutputBoundary similarListenersPresenter;

    public SimilarListenersInteractor(SimilarListenersUserDataAccessInterface userDataAccessInterface,
                                      SimilarListenersOutputBoundary similarListenersOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.similarListenersPresenter = similarListenersOutputBoundary;
    }

    @Override
    public void execute(SimilarListenersInputData similarListenersInputData) {
        // final String accessToken = similarListenersInputData.getAccessToken();
        if (userDataAccessObject.getFollowedArtists().isEmpty()) {
            similarListenersPresenter.prepareFailView("You do not follow any artists. "
                    + "Similar Listeners cannot be determined.");
        }
        else {
            final List<String> followedArtists = userDataAccessObject.getFollowedArtists();
            userDataAccessObject.setCurrentFollowedArtists(followedArtists);
            final SimilarListenersOutputData similarListenersOutputData = new SimilarListenersOutputData(
                    followedArtists, false);
            similarListenersPresenter.prepareSuccessView(similarListenersOutputData);
        }
    }

}

