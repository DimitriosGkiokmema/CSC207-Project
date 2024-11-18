package use_case.top_tracks;

import java.util.List;

public class TopTracksOutputData {

    private final List<String> tracks;
    private final List<String> time;
    private final boolean useCaseFailed;

    public TopTracksOutputData(List<String> tracks, List<String> time, boolean useCaseFailed) {
        this.tracks = tracks;
        this.time = time;
        this.useCaseFailed = useCaseFailed;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public List<String> getTime() {
        return time;
    }

}
