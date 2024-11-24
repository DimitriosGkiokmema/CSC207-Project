package use_case.top_items;

import java.util.List;

public class TopItemsOutputData {

    private final List<String> tracks;
    private final List<String> artists;
    private final boolean useCaseFailed;

    public TopItemsOutputData(List<String> tracks, List<String> artists, boolean useCaseFailed) {
        this.tracks = tracks;
        this.artists = artists;
        this.useCaseFailed = useCaseFailed;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public List<String> getArtists() {
        return artists;
    }
}
