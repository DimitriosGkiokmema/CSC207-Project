package interface_adapter.top_items;

import use_case.top_items.TopItemsInputBoundary;

/**
 * The controller for the TopItems Use Case.
 */
public class TopItemsController {
    private final TopItemsInputBoundary topItemsUseCaseInteractor;

    public TopItemsController(TopItemsInputBoundary topItemsUseCaseInteractor) {
        this.topItemsUseCaseInteractor = topItemsUseCaseInteractor;
    }

    /**
     * Executes the TopItems Use Case.
     */
    public void execute() {
        topItemsUseCaseInteractor.execute();
    }
}
