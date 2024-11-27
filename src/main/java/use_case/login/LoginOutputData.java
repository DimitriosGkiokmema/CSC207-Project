package use_case.login;

/**
 * Output Data for the Login Use Case.
 */
public class LoginOutputData {

    private final String accessToken;
    private final boolean useCaseFailed;

    public LoginOutputData(String accessToken, boolean useCaseFailed) {
        this.accessToken = accessToken;
        this.useCaseFailed = useCaseFailed;
    }

    public String getAccessToken() {
        return accessToken;
    }

}
