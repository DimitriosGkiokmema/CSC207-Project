package interface_adapter.top_items;

import java.util.List;

/**
 * The state for the Top Tracks View Model.
 */
public class TopItemsState {
    private List<String> tracks;
    private List<String> artists;
    private String tracksError;
    private String artistsError;
    private String accessToken;

    // Because of the previous copy constructor, the default constructor must be explicit.
    public TopItemsState() {
        // There is no need to assign anything in this constructor. The methods are do the assignment.
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

    public List<String> getArtists() {
        return artists;
    }

    public String getArtistsError() {
        return artistsError;
    }

    public void setArtists(List<String> artists) {
        this.artists = artists;
    }

    public void setArtistsError(String artistsError) {
        this.artistsError = artistsError;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }


}
