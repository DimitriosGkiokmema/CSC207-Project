package interface_adapter.similar_listeners;

import use_case.similar_listeners.SimilarListenersInputBoundary;

/**
 * The controller for SimilarListeners use case.
 */
public class SimilarListenersController {
    private final SimilarListenersInputBoundary similarListenersInputBoundary;

    public SimilarListenersController(SimilarListenersInputBoundary similarListenersUseCaseInteractor) {
        this.similarListenersInputBoundary = similarListenersUseCaseInteractor;
    }

    /**
     * Executes the Login Use Case.
     */
    public void execute() {
        similarListenersInputBoundary.execute();
    }
}

