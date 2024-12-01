package use_case.login;

import entity.User;

/**
 * DAO for the Login Use Case.
 */
public interface LoginUserDataAccessInterface {

    boolean existsByName(String identifier);

    /**
     * Saves the user.
     * @param user the user to save
     */
    void save(User user);

    /**
     * Returns the user with the given username.
     * @param username the username to look up
     * @return the user with the given username
     */
    User get(String username);

    /**
     * Returns the access token of the curren user of the application.
     * @return the access Token of the current user; null indicates that no one is logged into the application.
     */
    String getCurrentAccessToken();

    /**
     * Sets the access token indicating who is the current user of the application.
     * @param accessToken the new current access token; null to indicate that no one is currently logged into the
     *                    application.
     */
    void setCurrentAccessToken(String accessToken);
}
