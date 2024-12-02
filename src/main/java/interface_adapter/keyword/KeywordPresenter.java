package interface_adapter.keyword;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;
import use_case.keyword.KeywordOutputBoundary;
import use_case.keyword.KeywordOutputData;
/**
 * The Presenter for the Search Use Case.
 */
public class KeywordPresenter implements KeywordOutputBoundary {
    private LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;
    private KeywordViewModel keywordViewModel;

    public KeywordPresenter(ViewManagerModel viewManagerModel,
                           LoggedInViewModel loggedInViewModel,
                           KeywordViewModel keywordViewModel) {
        // Done: assign to the three instance variables.
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.keywordViewModel = keywordViewModel;

    }

    @Override
    public void prepareSuccessView(KeywordOutputData outputData) {
        final KeywordState keywordState = keywordViewModel.getState();
        keywordState.setDisplayText(outputData.getSongs());
        keywordViewModel.setState(keywordState);
        keywordViewModel.firePropertyChanged();
        // This code tells the View Manager to switch to the keyword.
        this.viewManagerModel.setState(keywordViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final KeywordState keywordState = keywordViewModel.getState();
        keywordState.setDisplayText(errorMessage); // Set error message to display
        keywordViewModel.setState(keywordState);
        keywordViewModel.firePropertyChanged(); // Notify view of changes
    }
}