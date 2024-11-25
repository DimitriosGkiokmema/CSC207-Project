package use_case.top_items;

import java.util.List;

/**
 * The Input Data for the TopItems Use Case.
 */
public class TopItemsInputData {

    private final List<String> tracks;
    private final List<String> artists;

    public TopItemsInputData(List<String> tracks, List<String> artists) {
        this.tracks = tracks;
        this.artists = artists;
    }

    List<String> getTracks() {
        return tracks;
    }

    List<String> getArtists() {
        return artists;
    }
}
