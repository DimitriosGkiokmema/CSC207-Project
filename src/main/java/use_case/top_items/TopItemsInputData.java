package use_case.top_items;

import java.util.List;

/**
 * The Input Data for the Top Tracks Use Case.
 */
public class TopItemsInputData {

    private final List<String> tracks;
    private final List<String> time;
    private final List<String> artists;

    public TopItemsInputData(List<String> tracks, List<String> artists, List<String> time) {
        this.tracks = tracks;
        this.artists = artists;
        this.time = time;
    }

    List<String> getTracks() {
        return tracks;
    }

    List<String> getArtists() {
        return artists;
    }

    List<String> getTime() {
        return time;
    }
}
