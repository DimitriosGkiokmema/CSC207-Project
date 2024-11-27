package use_case.top_items;

import java.util.List;

/**
 * The output data for the TopItems Use Case.
 */
public class TopItemsOutputData {

    private final List<String> tracks;
    private final List<String> artists;
    private String accessToken;

    public TopItemsOutputData(List<String> tracks, List<String> artists, String accessToken) {
        this.tracks = tracks;
        this.artists = artists;
        this.accessToken = accessToken;
    }

    public List<String> getTracks() {
        return tracks;
    }

    public List<String> getArtists() {
        return artists;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
