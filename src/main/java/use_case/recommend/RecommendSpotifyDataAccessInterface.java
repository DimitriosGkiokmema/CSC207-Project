package use_case.recommend;

import java.util.Map;

/**
 * The recommend DAO for accessing the Spotify api.
 */
public interface RecommendSpotifyDataAccessInterface {
    /**
     * Sends a query to the Spotify at the API endpoint.
     * @return a map of songs that the user listened to most recently
     */
    Map<String, String> getHistory();
}
