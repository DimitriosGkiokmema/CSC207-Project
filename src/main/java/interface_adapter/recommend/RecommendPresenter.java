package interface_adapter.recommend;

import interface_adapter.ViewManagerModel;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import use_case.recommend.RecommendOutputBoundary;
import use_case.recommend.RecommendOutputData;

/**
 * The Presenter for the Recommend Use Case.
 */
public class RecommendPresenter implements RecommendOutputBoundary {
    private final RecommendViewModel recommendViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecommendPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                              RecommendViewModel recommendViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.recommendViewModel = recommendViewModel;
    }

    @Override
    public void prepareSuccessView(RecommendOutputData response) {
        // On success, switch to the logged in (i.e. the home) view.

        final LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.viewManagerModel.setState(loggedInViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView() {
        recommendViewModel.firePropertyChanged();
    }
}
