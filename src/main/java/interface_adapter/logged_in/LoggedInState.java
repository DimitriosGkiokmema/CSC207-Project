package interface_adapter.logged_in;

/**
 * The State information representing the logged-in user.
 */
public class LoggedInState {

    private String accessToken = "";
    private String tokenError;

    public LoggedInState(LoggedInState copy) {
        accessToken = copy.accessToken;
        tokenError = copy.tokenError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {

    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void settokenError(String accessTokenError) {
        this.tokenError = accessTokenError;
    }

}
