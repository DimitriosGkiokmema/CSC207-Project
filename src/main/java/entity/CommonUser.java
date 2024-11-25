package entity;

/**
 * A simple implementation of the User interface.
 */
public class CommonUser implements User {

    private final String accessToken;

    public CommonUser(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }
}
