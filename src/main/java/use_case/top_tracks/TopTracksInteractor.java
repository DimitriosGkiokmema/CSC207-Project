package use_case.top_tracks;

import use_case.logout.LogoutOutputBoundary;
import use_case.logout.LogoutUserDataAccessInterface;

import java.util.List;

/**
 * The Top Tracks Interactor.
 */
public class TopTracksInteractor implements TopTracksInputBoundary{
    private TopTracksUserDataAccessInterface userDataAccessObject;
    private TopTracksOutputBoundary topTracksOutputBoundary;

    public TopTracksInteractor(TopTracksUserDataAccessInterface userDataAccessObject,
                               TopTracksOutputBoundary topTracksOutputBoundary) {
        // Which parameter is the DAO and which is the presenter?
        this.userDataAccessObject = userDataAccessObject;
        this.topTracksOutputBoundary = topTracksOutputBoundary;
    }

    @Override
    public void execute(TopTracksInputData topTracksInputData) {
        final List<String> topTracks = topTracksInputData.getTracks();
        final List<String> time = topTracksInputData.getTime();
        userDataAccessObject.setCurrentTopTracks(topTracks);
        userDataAccessObject.setCurrentTime(time);

        final TopTracksOutputData outputData = new TopTracksOutputData(topTracks, time, false);
        topTracksOutputBoundary.prepareSuccessView(outputData);
    }
}
