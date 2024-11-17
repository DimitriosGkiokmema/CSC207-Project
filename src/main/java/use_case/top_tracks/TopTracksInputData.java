package use_case.top_tracks;

import java.util.List;

/**
 * The Input Data for the Top Tracks Use Case.
 */
public class TopTracksInputData {

    private final List<String> tracks;
    private final List<String> time;

    public TopTracksInputData(List<String> tracks, List<String> time) {
        this.tracks = tracks;
        this.time = time;
    }

    List<String> getTracks() {
        return tracks;
    }

    List<String> getTime() {
        return time;
    }
}
