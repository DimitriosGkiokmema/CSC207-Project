package interface_adapter.recommend;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
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
    public void prepareSuccessView(RecommendOutputData output) {
        System.out.println("recommend output token: " + loggedInViewModel.getState().getAccessToken());
        final RecommendState recommendState = recommendViewModel.getState();
        recommendState.setAccessToken(output.getAccessToken());
        recommendState.setTopArtists(output.getCurrentTopArtists());
        recommendState.setSongRecommendations(output.getSongRecommendations());
        this.recommendViewModel.setState(recommendState);
        this.recommendViewModel.firePropertyChanged();

        this.viewManagerModel.setState(recommendViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        System.out.printf(errorMessage);
    }
}
