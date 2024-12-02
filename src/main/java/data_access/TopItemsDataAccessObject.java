package data_access;

import use_case.top_items.TopItemsDataAccessInterface;

import java.util.List;

public class TopItemsDataAccessObject implements TopItemsDataAccessInterface {

    private List<String> tracks;
    private List<String> artists;

    public TopItemsDataAccessObject() {
    }

    @Override
    public List<String> getCurrentTopTracks() {
        return tracks;
    }

    @Override
    public void setCurrentTopTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public List<String> getCurrentTopArtists() {
        return artists;
    }

    @Override
    public void setCurrentTopArtists(List<String> artists) {
        this.artists = artists;

    }
}
