package use_case.search;

import data_access.DBUserDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import use_case.login.LoginInputData;
import use_case.logout.LogoutOutputData;

/**
 * The Search Interactor.
 */
public class SearchInteractor implements SearchInputBoundary {

    private final SearchLanguageModelDataAccessInterface modelDataAccess;
    private final SearchOutputBoundary searchPresenter;

    /**
     * The Search Interactor constructor.
     * @param searchPresenter output information
     */
    public SearchInteractor(SearchLanguageModelDataAccessInterface modelDataAccess, SearchOutputBoundary searchPresenter) {
        this.modelDataAccess = modelDataAccess;

        this.searchPresenter = searchPresenter;
    }

    @Override
    public void execute(String accessToken) {
        final SearchOutputData search = new SearchOutputData(accessToken,false);
        searchPresenter.prepareSuccessView(search);
    }

    @Override
    public void executeSearch(String accessToken, String searchText){
        final SearchOutputData search = new SearchOutputData(accessToken,false);
        final String response = modelDataAccess.query(searchText);
        search.setDisplayText(response);
        searchPresenter.prepareSuccessView(search);
    }


}
