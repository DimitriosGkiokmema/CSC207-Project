package interface_adapter.recommend;

import interface_adapter.ViewModel;

/**
 * The View Model for the Recommendations View.
 */
public class RecommendViewModel extends ViewModel<RecommendState> {
    public RecommendViewModel() {
        super("recommendations");
        setState(new RecommendState());
    }
}
