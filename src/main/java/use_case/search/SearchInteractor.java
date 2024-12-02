package use_case.search;

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
    public void execute() {
        final SearchOutputData search = new SearchOutputData(false);
        searchPresenter.prepareSuccessView(search);
    }

    @Override
    public void executeSearch( String searchText){
        final SearchOutputData search = new SearchOutputData(false);
        final String response = modelDataAccess.query(searchText);
        search.setDisplayText(response);
        searchPresenter.prepareSuccessView(search);
    }


}
