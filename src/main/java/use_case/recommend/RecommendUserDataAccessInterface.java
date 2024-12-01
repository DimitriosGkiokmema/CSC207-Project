package use_case.recommend;

import java.util.List;
import java.util.SplittableRandom;

/**
 * DAO for the Recommendations Use Case.
 */
public interface RecommendUserDataAccessInterface {
    /**
     * Returns the top track list of the current user of the application.
     * @return the top track List of the current user; null indicates that there are no track lists.
     */
    List<String> getTopTracks();

    /**
     * Sets the top tracks list indicating who is the current user of the application.
     * @param tracks the new top track list; null to indicate that there is no top tracks.
     */
    void setTopTracks(List<String> tracks);

    /**
     * Returns the top artist list of the current user of the application.
     * @return the top artist list of the current user; null indicates that there are no artist lists.
     */
    String getTopArtists();

    /**
     * Sets the top artist list indicating who is the current user of the application.
     * @param artists the new top artist list; null to indicate that there is no top tracks.
     */
    void setTopArtists(String artists);

    String getRecommendations(List<String> songs, String topArtists);
}
