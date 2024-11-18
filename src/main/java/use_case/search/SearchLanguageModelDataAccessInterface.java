package use_case.search;

/**
 * The search DAO for accessing the Azure OpenAI api.
 */
public interface SearchLanguageModelDataAccessInterface {
    /**
     * Sends a query to the LLM at the API endpoint.
     * @param prompt is a string which the model will respond to
     * @return the model's response to that prompt
     */
    String query(String prompt);
}
