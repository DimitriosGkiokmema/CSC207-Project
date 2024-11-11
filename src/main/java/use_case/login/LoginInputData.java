package use_case.login;

/**
 * The Input Data for the Login Use Case.
 */
public class LoginInputData {

    private final String loginToken;

    public LoginInputData(String loginToken) {
        this.loginToken = loginToken;
    }

    String getLoginToken() {
        return loginToken;
    }

}
