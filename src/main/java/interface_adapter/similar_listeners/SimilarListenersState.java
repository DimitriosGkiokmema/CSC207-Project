package interface_adapter.similar_listeners;

import java.util.List;

/**
 * The state for Similar Listeners View Model.
 */
public class SimilarListenersState {
    private List<String> similarArtists;
    private String similarArtistsError;
    private String accessToken;

    public SimilarListenersState(SimilarListenersState copy) {
        similarArtists = copy.similarArtists;
        similarArtistsError = copy.similarArtistsError;
        accessToken = copy.accessToken;
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

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

}
