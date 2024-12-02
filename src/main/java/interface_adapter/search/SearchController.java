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
     */
    public void execute() {
        searchUseCaseInteractor.execute();
    }

    /**
     * Executes the Search Use Case.
     * @param searchText the search the user is inputting.
     */
    public void executeSearch( String searchText) {
        searchUseCaseInteractor.executeSearch(searchText);
    }
}
