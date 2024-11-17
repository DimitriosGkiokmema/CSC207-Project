package interface_adapter.top_tracks;

import interface_adapter.ViewManagerModel;
import use_case.top_tracks.TopTracksOutputBoundary;
import use_case.top_tracks.TopTracksOutputData;

/**
 * The Presenter for the Top Tracks Use Case.
 */
public class TopTracksPresenter implements TopTracksOutputBoundary{

    private final TopTracksViewModel topTracksViewModel;
    private final ViewManagerModel viewManagerModel;

    public TopTracksPresenter(ViewManagerModel viewManagerModel,
                              TopTracksViewModel topTracksViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.topTracksViewModel = topTracksViewModel;
    }

    @Override
    public void prepareSuccessView(TopTracksOutputData outputData) {
        final TopTracksState topTracksState = topTracksViewModel.getState();
        topTracksState.setTracks(outputData.getTracks());
        this.topTracksViewModel.setState(topTracksState);
        topTracksViewModel.firePropertyChanged();

        this.viewManagerModel.setState(topTracksViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final TopTracksState topTracksState = topTracksViewModel.getState();
        topTracksState.setTracksError(errorMessage);
        topTracksViewModel.firePropertyChanged();
    }
}
