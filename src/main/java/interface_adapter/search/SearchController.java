package interface_adapter.search;

import use_case.search.SearchInputBoundary;

/**
 * The controller for the Search Use Case.
 */
public class SearchController {

    private final SearchInputBoundary searchUseCaseInteractor;

    public SearchController(SearchInputBoundary searchUseCaseInteractor) {
        this.searchUseCaseInteractor = searchUseCaseInteractor;
    }

    /**
     * Goes to the search use case.
     * @param accessToken the access token for spotify.
     */
    public void execute(String accessToken) {
        searchUseCaseInteractor.execute(accessToken);
    }

    /**
     * Executes the Search Use Case.
     * @param searchText the search the user is inputting.
     * @param accessToken the access token for spotify.
     */
    public void executeSearch(String accessToken, String searchText) {
        searchUseCaseInteractor.executeSearch(accessToken, searchText);
    }
}
