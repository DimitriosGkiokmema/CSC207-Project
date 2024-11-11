package interface_adapter.signup;

/**
 * The state for the Signup View Model.
 */
public class SignupState {
    private String accessToken = "";
    private String accessTokenError;
    // private String password = "";
    // private String passwordError;
    // private String repeatPassword = "";
    // private String repeatPasswordError;

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessTokenError() {
        return accessTokenError;
    }

    /* public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public String getRepeatPasswordError() {
        return repeatPasswordError;
    } */

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public void setAccessTokenError(String acessTokenError) {
        this.accessTokenError = acessTokenError;
    }

   /*  public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }

    public void setRepeatPasswordError(String repeatPasswordError) {
        this.repeatPasswordError = repeatPasswordError;
    } */

    @Override
    public String toString() {
        return "SignupState{"
                + "username='" + accessToken + '\''
                + '}';
    }
}
