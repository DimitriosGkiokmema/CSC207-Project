package interface_adapter.top_items;

import java.util.List;

/**
 * The state for the Top Tracks View Model.
 */
public class TopItemsState {
    private List<String> tracks;
    private String tracksError;

    public TopItemsState(TopItemsState copy) {
        // tracks = copy.tracks;
        // tracksError = copy.tracksError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public TopItemsState() {

    }

    public List<String> getTracks() {
        return tracks;
    }

    public String getTracksError() {
        return tracksError;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    public void setTracksError(String tracksError) {
        this.tracksError = tracksError;
    }
}
