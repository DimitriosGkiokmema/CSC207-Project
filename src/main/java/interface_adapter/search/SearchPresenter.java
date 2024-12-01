package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import use_case.search.SearchOutputBoundary;
import use_case.search.SearchOutputData;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.logout.LogoutOutputBoundary;
import use_case.logout.LogoutOutputData;

/**
 * The Presenter for the Search Use Case.
 */
public class SearchPresenter implements SearchOutputBoundary {

    private LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;
    private SearchViewModel searchViewModel;

    public SearchPresenter(ViewManagerModel viewManagerModel,
                           LoggedInViewModel loggedInViewModel,
                           SearchViewModel searchViewModel) {
        // Done: assign to the three instance variables.
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
        this.searchViewModel = searchViewModel;

    }

    @Override
    public void prepareSuccessView(SearchOutputData response) {

        final SearchState searchState = searchViewModel.getState();
        searchState.setAccessToken(response.getAccessToken());
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
