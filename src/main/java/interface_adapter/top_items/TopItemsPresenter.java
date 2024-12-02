package interface_adapter.top_items;

import interface_adapter.ViewManagerModel;
import use_case.top_items.TopItemsOutputBoundary;
import use_case.top_items.TopItemsOutputData;

import java.util.ArrayList;

/**
 * The Presenter for the Top Tracks Use Case.
 */
public class TopItemsPresenter implements TopItemsOutputBoundary {

    private final TopItemsViewModel topItemsViewModel;
    private final ViewManagerModel viewManagerModel;

    public TopItemsPresenter(ViewManagerModel viewManagerModel,
                             TopItemsViewModel topItemsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.topItemsViewModel = topItemsViewModel;
    }

    @Override
    public void prepareSuccessView(TopItemsOutputData outputData) {
        final TopItemsState topItemsState = topItemsViewModel.getState();
        topItemsState.setTracks(outputData.getTracks());
        topItemsState.setArtists(outputData.getArtists());

        this.topItemsViewModel.setState(topItemsState);
        topItemsViewModel.firePropertyChanged();

        this.viewManagerModel.setState(topItemsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        final TopItemsState topItemsState = topItemsViewModel.getState();
        topItemsState.setTracksError(errorMessage);
        topItemsState.setArtistsError(errorMessage);
        topItemsState.setTracks(new ArrayList<>());
        topItemsState.setArtists(new ArrayList<>());

        this.viewManagerModel.setState(topItemsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
