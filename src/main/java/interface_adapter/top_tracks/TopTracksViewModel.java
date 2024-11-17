package interface_adapter.top_tracks;

import interface_adapter.ViewModel;

/**
 * The View Model for the Top Tracks View.
 */
public class TopTracksViewModel extends ViewModel<TopTracksState> {
    public TopTracksViewModel() {
        super("Top Tracks");
        setState(new TopTracksState());
    }
}
