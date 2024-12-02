package use_case.login;

/**
 * The Input Data for the Login Use Case.
 */
public class LoginInputData {

    private final String accessToken;

    public LoginInputData(String accessToken) {
        this.accessToken = accessToken;
    }
    public LoginInputData() {
        accessToken = "noToken";
    }

    String getAccessToken() {
        return accessToken;
    }

}
