package use_case.top_items;

import java.util.List;

/**
 * The Input Data for the TopItems Use Case.
 */
public class TopItemsInputData {

    private final List<String> tracks;
    private final List<String> artists;
    private String accessToken;

    public TopItemsInputData(List<String> tracks, List<String> artists, String accessToken) {
        this.tracks = tracks;
        this.artists = artists;
        this.accessToken = accessToken;
    }

    List<String> getTracks() {
        return tracks;
    }

    List<String> getArtists() {
        return artists;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
