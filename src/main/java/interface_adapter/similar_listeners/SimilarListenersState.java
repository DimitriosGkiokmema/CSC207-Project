package interface_adapter.similar_listeners;

import java.util.List;

public class SimilarListenersState {
    private List<String> similarArtists;
    private String similarArtistsError;

    public SimilarListenersState(SimilarListenersState copy) {
        similarArtists = copy.similarArtists;
        similarArtistsError = copy.similarArtistsError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SimilarListenersState() {

    }

    public List<String> getSimilarArtists() {
        return similarArtists;
    }

    public void setSimilarArtists(List<String> similarArtists) {
        this.similarArtists = similarArtists;
    }

    public String getSimilarArtistsError() {
        return similarArtistsError;
    }

    void setSimilarArtistsError(String similarArtistsError) {
        this.similarArtistsError = similarArtistsError;
    }

}
