package use_case.top_items;

import java.util.List;

/**
 * The TopItems Interactor.
 */
public class TopItemsInteractor implements TopItemsInputBoundary {
    private TopItemsDataAccessInterface userDataAccessObject;
    private TopItemsOutputBoundary topItemsOutputBoundary;

    public TopItemsInteractor(TopItemsDataAccessInterface userDataAccessObject,
                              TopItemsOutputBoundary topItemsOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.topItemsOutputBoundary = topItemsOutputBoundary;
    }

    @Override
    public void execute(TopItemsInputData topItemsInputData) {
        if (userDataAccessObject.getCurrentTopTracks().isEmpty() || userDataAccessObject.getCurrentTopArtists()
                .isEmpty()) {
            if (userDataAccessObject.getCurrentTopArtists().isEmpty() && userDataAccessObject.getCurrentTopTracks()
                    .isEmpty()) {
                topItemsOutputBoundary.prepareFailView("Top Tracks and Top Artists cannot be determined");
            }
            else if (userDataAccessObject.getCurrentTopTracks().isEmpty()) {
                topItemsOutputBoundary.prepareFailView("Top Tracks cannot be determined");
            }
            else {
                topItemsOutputBoundary.prepareFailView("Top Artists cannot be determined");
            }
        }
        else {
            final List<String> topTracks = userDataAccessObject.getCurrentTopTracks();
            final List<String> topArtists = userDataAccessObject.getCurrentTopArtists();
            final TopItemsOutputData outputData = new TopItemsOutputData(topTracks, topArtists);
            topItemsOutputBoundary.prepareSuccessView(outputData);

        }
    }
}
