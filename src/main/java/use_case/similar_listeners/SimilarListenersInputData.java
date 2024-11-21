package use_case.similar_listeners;

public class SimilarListenersInputData {

    private final String accessToken;

    public SimilarListenersInputData(String accessToken) {
        this.accessToken = accessToken;
    }

    String getLoginToken() {
        return accessToken;
    }

}
