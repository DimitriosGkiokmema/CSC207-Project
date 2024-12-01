package interface_adapter.similar_listeners;

import interface_adapter.ViewManagerModel;
import use_case.similar_listeners.SimilarListenersOutputBoundary;
import use_case.similar_listeners.SimilarListenersOutputData;

import java.util.ArrayList;

/**
 * The Presenter for Similar Listeners use case.
 */
public class SimilarListenersPresenter implements SimilarListenersOutputBoundary {
    private final SimilarListenersViewModel similarListenersViewModel;
    private final ViewManagerModel viewManagerModel;

    public SimilarListenersPresenter(SimilarListenersViewModel similarListenersViewModel,
                                     ViewManagerModel viewManagerModel) {
        this.similarListenersViewModel = similarListenersViewModel;
        this.viewManagerModel = viewManagerModel;

    }

    @Override
    public void prepareSuccessView(SimilarListenersOutputData similarListenersOutputData) {
        final SimilarListenersState similarListenersState = similarListenersViewModel.getState();
        similarListenersState.setSimilarArtists(similarListenersOutputData.getSimilarArtists());
        similarListenersState.setAccessToken(similarListenersOutputData.getAccessToken());
        this.similarListenersViewModel.setState(similarListenersState);
        similarListenersViewModel.firePropertyChanged();

        this.viewManagerModel.setState(similarListenersViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String errorMessage) {
        final SimilarListenersState similarListenersState = similarListenersViewModel.getState();
        similarListenersState.setSimilarArtistsError(errorMessage);
        similarListenersState.setSimilarArtists(new ArrayList<>());
        similarListenersViewModel.firePropertyChanged();

        this.viewManagerModel.setState(similarListenersViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }
}
