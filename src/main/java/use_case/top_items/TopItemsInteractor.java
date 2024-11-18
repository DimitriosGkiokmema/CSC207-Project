package use_case.top_items;

import java.util.List;

/**
 * The Top Tracks Interactor.
 */
public class TopItemsInteractor implements TopItemsInputBoundary {
    private TopItemsUserDataAccessInterface userDataAccessObject;
    private TopItemsOutputBoundary topItemsOutputBoundary;

    public TopItemsInteractor(TopItemsUserDataAccessInterface userDataAccessObject,
                              TopItemsOutputBoundary topItemsOutputBoundary) {
        // Which parameter is the DAO and which is the presenter?
        this.userDataAccessObject = userDataAccessObject;
        this.topItemsOutputBoundary = topItemsOutputBoundary;
    }

    @Override
    public void execute(TopItemsInputData topItemsInputData) {
        final List<String> topTracks = topItemsInputData.getTracks();
        final List<String> time = topItemsInputData.getTime();
        userDataAccessObject.setCurrentTopTracks(topTracks);
        userDataAccessObject.setCurrentTime(time);

        final TopItemsOutputData outputData = new TopItemsOutputData(topTracks, time, false);
        topItemsOutputBoundary.prepareSuccessView(outputData);
    }
}
