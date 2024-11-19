package entity;

/**
 * A simple implementation of the User interface.
 */
public class CommonUser implements User {

    private final String accessToken;
    // private final String password;

    public CommonUser(String accessToken) {
        this.accessToken = accessToken;
        // this.password = password;
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    /* @Override
    public String getPassword() {
        return password;
    } */
}
