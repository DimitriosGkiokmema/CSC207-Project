package interface_adapter.recommend;

import java.util.ArrayList;

import interface_adapter.ViewManagerModel;
import use_case.recommend.RecommendOutputBoundary;
import use_case.recommend.RecommendOutputData;

/**
 * The Presenter for the Recommend Use Case.
 */
public class RecommendPresenter implements RecommendOutputBoundary {
    private final RecommendViewModel recommendViewModel;
    private final ViewManagerModel viewManagerModel;

    public RecommendPresenter(ViewManagerModel viewManagerModel,
                              RecommendViewModel recommendViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.recommendViewModel = recommendViewModel;
    }

    @Override
    public void prepareSuccessView(RecommendOutputData output) {
        final RecommendState recommendState = recommendViewModel.getState();
        recommendState.setTopArtists(output.getCurrentTopArtists());
        recommendState.setSongRecommendations(output.getSongRecommendations());
        this.recommendViewModel.setState(recommendState);
        this.recommendViewModel.firePropertyChanged();

        this.viewManagerModel.setState(recommendViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final RecommendState state = recommendViewModel.getState();
        state.setTracksError(errorMessage);
        state.setArtistsError(errorMessage);
        state.setSongRecommendations("No recommendations were able to be found");
        state.setTopArtists(new ArrayList<>());

        this.viewManagerModel.setState(recommendViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
