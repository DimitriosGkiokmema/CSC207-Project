package interface_adapter.search;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import use_case.search.SearchOutputBoundary;

public class SearchPresenter implements SearchOutputBoundary {
    public SearchPresenter(ViewManagerModel viewManagerModel, LoggedInViewModel loggedInViewModel, LoginViewModel loginViewModel) {
    }
}
