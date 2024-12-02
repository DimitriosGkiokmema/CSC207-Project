package use_case.recommend;

import java.util.List;

/**
 * DAO for the Recommendations Use Case.
 */
public interface RecommendDataAccessInterface {
    /**
     * Returns the top track list of the current user of the application.
     * @return the top track List of the current user; null indicates that there are no track lists.
     */
    List<String> getCurrentTopTracks2();

    /**
     * Sets the top tracks list indicating who is the current user of the application.
     * @param tracks the new top track list; null to indicate that there is no top tracks.
     */
    void setCurrentTopTracks2(List<String> tracks);

    /**
     * Returns the top artist list of the current user of the application.
     * @return the top artist list of the current user; null indicates that there are no artist lists.
     */
    List<String> getCurrentTopArtists2();

    /**
     * Sets the top artist list indicating who is the current user of the application.
     * @param artists the new top artist list; null to indicate that there is no top tracks.
     */
    void setCurrentTopArtists2(List<String> artists);

    void setAccessToken(String accessToken);
}
