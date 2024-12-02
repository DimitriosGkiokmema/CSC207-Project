package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;


/**
 * The Presenter for the Search Use Case.
 */
public class SearchPresenter implements SearchOutputBoundary {

    final private ViewManagerModel viewManagerModel;
    final private SearchViewModel searchViewModel;

    public SearchPresenter(ViewManagerModel viewManagerModel,
                           SearchViewModel searchViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchViewModel = searchViewModel;

    }

    @Override
    public void prepareSuccessView(SearchOutputData response) {

        final SearchState searchState = searchViewModel.getState();
        searchState.setDisplayText(response.getDisplayText());
        searchViewModel.setState(searchState);
        searchViewModel.firePropertyChanged();


        // This code tells the View Manager to switch to the Search.
        this.viewManagerModel.setState(searchViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // No need to add code here. We'll assume that logout can't fail.
        // Thought question: is this a reasonable assumption?
    }
}
