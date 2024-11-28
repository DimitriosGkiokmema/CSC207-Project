package use_case.recommend;

import java.util.List;

/**
* The recommend DAO for accessing the Azure OpenAI api.
 */
public interface RecommendLanguageModelDataAccessInterface {
    /**
     * Sends a query to the LLM at the API endpoint.
     * @param prompt is a list of strings which the model will respond to
     * @return the model's response to that prompt
     */
    String getRecommendations(List<String> prompt, String topArtists);
}
