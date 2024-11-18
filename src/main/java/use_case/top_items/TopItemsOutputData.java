package use_case.top_items;

import java.util.List;

public class TopItemsOutputData {

    private final List<String> tracks;
    private final List<String> time;
    private final boolean useCaseFailed;

    public TopItemsOutputData(List<String> tracks, List<String> time, boolean useCaseFailed) {
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
