package use_case.signup;

/**
 * The Input Data for the Signup Use Case.
 */
public class SignupInputData {

    private final String accessToken;
    // private final String password;
    // private final String repeatPassword;

    public SignupInputData(String accessToken) {
        this.accessToken = accessToken;
        // this.password = password;
        // this.repeatPassword = repeatPassword;
    }

    String getAccessToken() {
        return accessToken;
    }

    /* String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    } */
}
