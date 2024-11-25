package use_case.top_items;

import java.util.List;

/**
 * The TopItems Interactor.
 */
public class TopItemsInteractor implements TopItemsInputBoundary {
    private TopItemsUserDataAccessInterface userDataAccessObject;
    private TopItemsOutputBoundary topItemsOutputBoundary;

    public TopItemsInteractor(TopItemsUserDataAccessInterface userDataAccessObject,
                              TopItemsOutputBoundary topItemsOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.topItemsOutputBoundary = topItemsOutputBoundary;
    }

    @Override
    public void execute(TopItemsInputData topItemsInputData) {
        final List<String> topTracks = userDataAccessObject.getCurrentTopTracks();
        final List<String> topArtists = userDataAccessObject.getCurrentTopArtists();

        final TopItemsOutputData outputData = new TopItemsOutputData(topTracks, topArtists);
        topItemsOutputBoundary.prepareSuccessView(outputData);
    }
}
