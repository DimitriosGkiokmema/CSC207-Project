package data_access;

import use_case.top_items.TopItemsUserDataAccessInterface;

import java.util.List;

public class TopItemsUserDataAccessObject implements TopItemsUserDataAccessInterface {

    @Override
    public List<String> getCurrentTopTracks() {
        return List.of();
    }

    @Override
    public void setCurrentTopTracks(List<String> tracks) {

    }

    @Override
    public List<String> getCurrentTopArtists() {
        return List.of();
    }

    @Override
    public void setCurrentTopArtists(List<String> artists) {

    }
}
