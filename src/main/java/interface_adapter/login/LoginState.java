package interface_adapter.login;

/**
 * The state for the Login View Model.
 */
public class LoginState {
    private String loginToken = "";
    private String loginError;

    public String getLoginToken() {
        return loginToken;
    }

    public String getLoginError() {
        return loginError;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public void setLoginError(String accessTokenError) {
        this.loginError = accessTokenError;
    }
}
