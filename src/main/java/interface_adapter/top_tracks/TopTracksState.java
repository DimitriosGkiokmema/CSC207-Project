package interface_adapter.top_tracks;

import java.util.ArrayList;
import java.util.List;

/**
 * The state for the Top Tracks View Model.
 */
public class TopTracksState {
    private List<String> tracks = new ArrayList<>();
    private String tracksError;

    public TopTracksState(TopTracksState copy) {
        tracks = copy.tracks;
        tracksError = copy.tracksError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public TopTracksState() {

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
