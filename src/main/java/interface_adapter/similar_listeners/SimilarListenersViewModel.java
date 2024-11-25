package interface_adapter.similar_listeners;

import interface_adapter.ViewModel;

/**
 * The View Model for SimilarListeners View.
 */
public class SimilarListenersViewModel extends ViewModel<SimilarListenersState> {
    public SimilarListenersViewModel() {
        super("similar listeners");
        setState(new SimilarListenersState());
    }
}
