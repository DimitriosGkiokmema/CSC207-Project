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
     * @param loginToken the username of the user logging in
     */
    public void execute(String loginToken) {
        final LoginInputData loginInputData = new LoginInputData(
                loginToken);

        searchUseCaseInteractor.execute(loginInputData);
    }
}
