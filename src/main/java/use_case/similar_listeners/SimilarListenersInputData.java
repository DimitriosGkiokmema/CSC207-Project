package use_case.similar_listeners;

import java.util.ArrayList;
import java.util.List;

public class SimilarListenersInputData {

    private final String accessToken;
    private final List<String> artistsFollowed;

    public SimilarListenersInputData(String accessToken, ArrayList<String> artistsFollowed) {

        this.accessToken = accessToken;
        this.artistsFollowed = artistsFollowed;
    }

    String getAccessToken() {
        return accessToken;
    }

    List<String> getArtistsFollowed() {
        return artistsFollowed;
    }

}
