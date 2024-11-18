package use_case.top_items;

import java.util.List;

/**
 * DAO for the Top Tracks Use Case.
 */
public interface TopItemsUserDataAccessInterface {

    /**
     * Returns the top track List of the current user of the application.
     * @return the top track List of the current user; null indicates that there are no track lists.
     */
    List<String> getCurrentTopTracks();

    /**
     * Sets the top tracks list indicating who is the current user of the application.
     * @param tracks the new top track list; null to indicate that there is no top tracks.
     */
    void setCurrentTopTracks(List<String> tracks);

    /**
     * Returns the top artist List of the current user of the application.
     * @return the top artist List of the current user; null indicates that there are no artist lists.
     */
    List<String> getCurrentTopArtists();

    /**
     * Sets the top artist list indicating who is the current user of the application.
     * @param artists the new top artist list; null to indicate that there is no top tracks.
     */
    void setCurrentTopArtists(List<String> artists);


    /**
     * Returns the top track List of the current user of the application.
     * @return the access Token of the current user; null indicates that no one is logged into the application.
     */
    List<String> getCurrentTime();

    /**
     * Sets the top tracks list indicating who is the current user of the application.
     * @param time the new top track list; null to indicate that no one is currently logged into the
     *                    application.
     */
    void setCurrentTime(List<String> time);
}