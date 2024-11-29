package use_case.recommend;

import java.util.List;

/**
 * The recommend DAO for accessing the Spotify api.
 */
public interface RecommendSpotifyDataAccessInterface {
    /**
     * Sends a query to the Spotify at the API endpoint.
     * @return a map of songs that the user listened to most recently
     */
    List<String> getTopTracks();

    /**
     * Sends a query to the Spotify at the API endpoint.
     * @return a String of the user's top artists
     */
    String getTopArtists();
}
