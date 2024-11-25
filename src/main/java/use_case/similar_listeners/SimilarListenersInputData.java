package use_case.similar_listeners;

import java.util.ArrayList;
import java.util.List;

/**
 * The input data for SimilarListeners use case.
 */
public class SimilarListenersInputData {

    private final String accessToken;
    // private final List<String> artistsFollowed;

    public SimilarListenersInputData(String accessToken) {

        this.accessToken = accessToken;
        // this.artistsFollowed = artistsFollowed;
    }

    String getAccessToken() {
        return accessToken;
    }

    // List<String> getArtistsFollowed() {
    // return artistsFollowed;
    // }

}
