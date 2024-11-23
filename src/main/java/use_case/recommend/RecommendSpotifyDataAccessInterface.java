package use_case.recommend;

import java.util.List;

/**
 * The recommend DAO for accessing the Spotify api.
 */
public interface RecommendSpotifyDataAccessInterface {
    /**
     * Sends a query to the Spotify at the API endpoint.
     * @return a list of songs that the user listened to most recently
     */
    List<String> getHistory();
}
