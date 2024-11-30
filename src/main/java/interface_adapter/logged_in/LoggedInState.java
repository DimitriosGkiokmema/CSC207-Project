package interface_adapter.logged_in;

/**
 * The State information representing the logged-in user.
 */
public class LoggedInState {
    private String accessToken = "";

    public LoggedInState(LoggedInState copy) {
        accessToken = copy.accessToken;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
