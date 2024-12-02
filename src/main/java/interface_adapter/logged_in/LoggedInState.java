package interface_adapter.logged_in;

/**
 * The State information representing the logged-in user.
 */
public class LoggedInState {
    private String tokenError;

    public LoggedInState(LoggedInState copy) {
        tokenError = copy.tokenError;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {

    }
    public void settokenError(String accessTokenError) {
        this.tokenError = accessTokenError;
    }

}
