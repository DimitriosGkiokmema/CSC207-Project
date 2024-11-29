package use_case.similar_listeners;

import java.util.ArrayList;
import java.util.List;

/**
 * The input data for SimilarListeners use case.
 */
public class SimilarListenersInputData {

    private final String accessToken;

    public SimilarListenersInputData(String accessToken) {

        this.accessToken = accessToken;
    }

    String getAccessToken() {
        return accessToken;
    }


}
