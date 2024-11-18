package interface_adapter.top_tracks;

import use_case.logout.LogoutInputData;
import use_case.top_tracks.TopTracksInputBoundary;
import use_case.top_tracks.TopTracksInputData;

import java.util.List;

/**
 * The controller for the TopTracks and Artists Use Case.
 */
public class TopTracksController {
    private TopTracksInputBoundary topTracksInputBoundary;

    public TopTracksController(TopTracksInputBoundary topTracksInputBoundary) {
        this.topTracksInputBoundary = topTracksInputBoundary;
    }

    /**
     * Executes the Logout Use Case.
     * @param toptracks the username of the user logging in
     * @param time nfvenprne
     */
    public void execute(List<String> toptracks, List<String> time) {
        // 1. instantiate the `LogoutInputData`, which should contain the username.
        // 2. tell the Interactor to execute.
        final TopTracksInputData topTracksInputData = new TopTracksInputData(toptracks, time);
        topTracksInputBoundary.execute(topTracksInputData);
    }
}
