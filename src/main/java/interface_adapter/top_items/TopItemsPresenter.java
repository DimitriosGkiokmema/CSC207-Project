package interface_adapter.top_items;

import interface_adapter.ViewManagerModel;
import use_case.top_items.TopItemsOutputBoundary;
import use_case.top_items.TopItemsOutputData;

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

        this.topItemsViewModel.setState(topItemsState);
        topItemsViewModel.firePropertyChanged();

        this.viewManagerModel.setState(topItemsViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String errorMessage) {
        // No code needed because there won't be an error.
        /* final TopItemsState topItemsState = topItemsViewModel.getState();
        topItemsState.setTracksError(errorMessage);
        topItemsViewModel.firePropertyChanged(); */
    }
}
