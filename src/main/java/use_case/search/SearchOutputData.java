package use_case.search;
/**
 * Output Data for the Search Use Case.
 */
public class SearchOutputData {

    private String accessToken;
    private boolean useCaseFailed;

    public SearchOutputData(String token, boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
        this.accessToken = token;

    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
