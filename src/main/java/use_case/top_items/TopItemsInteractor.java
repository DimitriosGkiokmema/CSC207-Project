package use_case.top_items;

import java.util.List;

/**
 * The TopItems Interactor.
 */
public class TopItemsInteractor implements TopItemsInputBoundary {
    private final TopItemsDataAccessInterface userDataAccessObject;
    private final TopItemsOutputBoundary topItemsOutputBoundary;

    public TopItemsInteractor(TopItemsDataAccessInterface userDataAccessObject,
                              TopItemsOutputBoundary topItemsOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.topItemsOutputBoundary = topItemsOutputBoundary;
    }

    @Override
    public void execute() {
        // The first if statement checks either one of the Top Artists or Top Tracks is empty.
        if (userDataAccessObject.getCurrentTopTracks().isEmpty() || userDataAccessObject.getCurrentTopArtists()
                .isEmpty()) {
            // The if statement below checks whether both Top Artists and Top Tracks are empty and prints a message
            // accordingly .
            if (userDataAccessObject.getCurrentTopArtists().isEmpty() && userDataAccessObject.getCurrentTopTracks()
                    .isEmpty()) {
                topItemsOutputBoundary.prepareFailView("Top Tracks and Top Artists cannot be determined");
            }
            // The if statement below checks whether only Top Tracks are empty and prints an error message accordingly.
            else if (userDataAccessObject.getCurrentTopTracks().isEmpty()) {
                topItemsOutputBoundary.prepareFailView("Top Tracks cannot be determined");
            }
            // The remaining else statement is an error message for Empty Top Artist lists.
            else {
                topItemsOutputBoundary.prepareFailView("Top Artists cannot be determined");
            }
        }
        else {
            // Prepares the success view when both lists exist.
            final List<String> topTracks = userDataAccessObject.getCurrentTopTracks();
            final List<String> topArtists = userDataAccessObject.getCurrentTopArtists();
            final TopItemsOutputData outputData = new TopItemsOutputData(topTracks, topArtists);
            topItemsOutputBoundary.prepareSuccessView(outputData);

        }
    }
}
