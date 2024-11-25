package use_case.top_items;

import java.util.List;

/**
 * The output data for the TopItems Use Case.
 */
public class TopItemsOutputData {

    private final List<String> tracks;
    private final List<String> artists;

    public TopItemsOutputData(List<String> tracks, List<String> artists) {
        this.tracks = tracks;
        this.artists = artists;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public List<String> getArtists() {
        return artists;
    }
}
