package use_case.recommend;

import java.util.Map;

/**
* The recommend DAO for accessing the Azure OpenAI api.
 */
public interface RecommendLanguageModelDataAccessInterface {
    /**
     * Sends a query to the LLM at the API endpoint.
     * @param prompt is a string which the model will respond to
     * @return the model's response to that prompt
     */
    String getRecommendations(Map<String, String> prompt);
}
