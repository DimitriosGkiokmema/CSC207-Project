package use_case.similar_listeners;

import java.util.List;

/**
 * DAO for SimilarListeners use case.
 */
public interface SimilarListenersDataAccessInterface {

    /**
     * Return the artists that the current user follows.
     * @return list of artists that this user follows. Return an empty list if there are no followed artists.
     */
    List<String> getFollowedArtists();

    /**
     * Sets the users followed artists.
     * @param followedArtists is the list of artists names.
     */
    void setCurrentFollowedArtists(List<String> followedArtists);

}
