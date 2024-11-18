package use_case.similar_listeners;

public class SimilarListenersInputData {

    private final String loginToken;

    public SimilarListenersInputData(String loginToken) {
        this.loginToken = loginToken;
    }

    String getLoginToken() {
        return loginToken;
    }

}
