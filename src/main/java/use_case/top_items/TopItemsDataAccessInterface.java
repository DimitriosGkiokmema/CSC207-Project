package use_case.top_items;

import java.util.List;

/**
 * DAO for the Top Tracks Use Case.
 */
public interface TopItemsDataAccessInterface {

    /**
     * Returns the top track list of the current user of the application.
     * @return the top track List of the current user; null indicates that there are no track lists.
     */
    List<String> getCurrentTopTracks();

    /**
     * Sets the top tracks list indicating who is the current user of the application.
     * @param tracks the new top track list; null to indicate that there is no top tracks.
     */
    void setCurrentTopTracks(List<String> tracks);

    /**
     * Returns the top artist list of the current user of the application.
     * @return the top artist list of the current user; null indicates that there are no artist lists.
     */
    List<String> getCurrentTopArtists();

    /**
     * Sets the top artist list indicating who is the current user of the application.
     * @param artists the new top artist list; null to indicate that there is no top tracks.
     */
    void setCurrentTopArtists(List<String> artists);
}
