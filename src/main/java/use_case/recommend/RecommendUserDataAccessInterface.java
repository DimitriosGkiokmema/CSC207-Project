package use_case.recommend;

import java.util.Map;

/**
 * DAO for the Recommendations Use Case.
 */
public interface RecommendUserDataAccessInterface {
    /**
     * Returns the song recommendation Map of the current user of the application.
     * @return the recommendations Map of the current user; null indicates that there are no recommendation Maps
     */
    Map<String, String> getSongRecommendations();

    /**
     * Sets the song recommendations map.
     * @param songRecommendations the new song recommendation Map; null to indicate that there is no recommendations.
     */
    void setSongRecommendations(Map<String, String> songRecommendations);
}
