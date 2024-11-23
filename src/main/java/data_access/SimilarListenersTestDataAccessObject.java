package data_access;

import use_case.similar_listeners.SimilarListenersUserDataAccessInterface;

import java.util.List;

public class SimilarListenersTestDataAccessObject implements SimilarListenersUserDataAccessInterface {

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
