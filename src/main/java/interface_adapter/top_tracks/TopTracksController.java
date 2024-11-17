package interface_adapter.top_tracks;

import use_case.top_tracks.TopTracksInputBoundary;

/**
 * The controller for the TopTracks and Artists Use Case.
 */
public class TopTracksController {
    private TopTracksInputBoundary topTracksInputBoundary;

    public TopTracksController(TopTracksInputBoundary topTracksInputBoundary) {
        this.topTracksInputBoundary = topTracksInputBoundary;
    }
}
