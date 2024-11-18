package use_case.similar_listeners;

import java.util.List;

import entity.User;

/**
 * DAO for SimilarListeners use case.
 */
public interface SimilarListenersUserDataAccessInterface {

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
     * Return the artists that the current user follows.
     * @return list of artists that this user follows.
     */
    List<String> getFollowedArtists();

    void setCurrentFollowedArtists(List<String> followedArtists);


}
