package use_case.search;

import data_access.InMemoryUserDataAccessObject;
import use_case.login.LoginInputData;

/**
 * The Search Interactor.
 */
public class SearchInteractor implements SearchInputBoundary {

    private final InMemoryUserDataAccessObject userDataAccessObject;
    private final SearchOutputBoundary searchOutputBoundary;

    /**
     * The Search Interactor constructor.
     * @param userDataAccessObject abstract data acess object
     * @param searchOutputBoundary output information
     */
    public SearchInteractor(InMemoryUserDataAccessObject userDataAccessObject,
                            SearchOutputBoundary searchOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.searchOutputBoundary = searchOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {

    }
}
