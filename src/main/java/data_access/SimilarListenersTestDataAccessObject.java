package data_access;

import use_case.similar_listeners.SimilarListenersDataAccessInterface;

import java.util.List;

public class SimilarListenersTestDataAccessObject implements SimilarListenersDataAccessInterface {

    private List<String> followedArtists;

    @Override
    public List<String> getFollowedArtists() {
        return this.followedArtists;
    }

    @Override
    public void setCurrentFollowedArtists(List<String> artists) {
        this.followedArtists = artists;

    }
}
