package use_case.search;

/**
 * Input Boundary for actions which are going to the search page.
 */
public interface SearchInputBoundary {
    /**
     * Executes the Search use case.
     */
    void execute(String accessToken);

    /**
     * Executes the Search use case.
     */
    void executeSearch(String accessToken, String searchText);
}
