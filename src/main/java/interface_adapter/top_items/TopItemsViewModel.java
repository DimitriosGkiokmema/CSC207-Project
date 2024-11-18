package interface_adapter.top_items;

import interface_adapter.ViewModel;

/**
 * The View Model for the Top Tracks View.
 */
public class TopItemsViewModel extends ViewModel<TopItemsState> {
    public TopItemsViewModel() {
        super("Top Items");
        setState(new TopItemsState());
    }
}
