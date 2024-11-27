package data_access;

import use_case.top_items.TopItemsUserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class TopItemsUserDataAccessObject implements TopItemsUserDataAccessInterface {

    private List<String> tracks;
    private List<String> artists;

    public TopItemsUserDataAccessObject() {
        tracks = new ArrayList<>();
        artists = new ArrayList<>();
        tracks.add("Heartbreaker");
        tracks.add("reincarnated");
        tracks.add("Kill Bill");
        tracks.add("Crew Love");
        artists.add("The Weeknd");
        artists.add("Kanye West");
        artists.add("A$AP Rocky");

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
        return artists;
    }

    @Override
    public void setCurrentTopArtists(List<String> artists) {

    }
}
