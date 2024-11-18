package use_case.top_tracks;

/**
 * Input Boundary for actions which are related to Top Tracks Charts in.
 */
public interface TopTracksInputBoundary {

    /**
     * Executes the Logout use case.
     * @param topTracksInputData the input data
     */
    void execute(TopTracksInputData topTracksInputData);
}
