package use_case.search;

import data_access.InMemoryUserDataAccessObject;
import use_case.login.LoginInputData;
import use_case.logout.LogoutOutputData;

/**
 * The Search Interactor.
 */
public class SearchInteractor implements SearchInputBoundary {

    private final SearchOutputBoundary searchPresenter;

    /**
     * The Search Interactor constructor.
     * @param searchPresenter output information
     */
    public SearchInteractor(SearchOutputBoundary searchPresenter) {

        this.searchPresenter = searchPresenter;
    }

    @Override
    public void execute() {
        final SearchOutputData search = new SearchOutputData(false);
        searchPresenter.prepareSuccessView(search);
    }
}
