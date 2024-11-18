package use_case.recommend;

/**
 * The Input Data for the Recommend Use Case.
 */
public class RecommendInputData {

    private final String accessToken;

    public RecommendInputData(String accessToken) {
        this.accessToken = accessToken;
    }

    String getAccessToken() {
        return accessToken;
    }
}
