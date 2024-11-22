package interface_adapter.search;


import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;
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
     * Executes the Search Use Case.
     */
    public void execute() {
        searchUseCaseInteractor.execute();
    }
}
