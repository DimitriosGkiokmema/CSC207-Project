package data_access;

import use_case.top_items.TopItemsUserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class TopItemsUserDataAccessObject implements TopItemsUserDataAccessInterface {

    private List<String> tracks;

    public TopItemsUserDataAccessObject() {
        tracks = new ArrayList<>();
        tracks.add("Heartbreaker");
        tracks.add("reincarnated");
        tracks.add("Kill Bill");
        tracks.add("Crew Love");
    }

    @Override
    public List<String> getCurrentTopTracks() {
        return tracks;
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
