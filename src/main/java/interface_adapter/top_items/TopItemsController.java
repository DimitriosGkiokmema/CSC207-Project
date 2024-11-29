package interface_adapter.top_items;

import use_case.top_items.TopItemsInputBoundary;
import use_case.top_items.TopItemsInputData;

import java.util.List;

/**
 * The controller for the TopItems Use Case.
 */
public class TopItemsController {
    private TopItemsInputBoundary topItemsUseCaseInteractor;

    public TopItemsController(TopItemsInputBoundary topItemsUseCaseInteractor) {
        this.topItemsUseCaseInteractor = topItemsUseCaseInteractor;
    }

    /**
     * Executes the TopItems Use Case.
     * @param accessToken the access Token of the user.
     */
    public void execute(String accessToken) {
        final TopItemsInputData topItemsInputData = new TopItemsInputData(accessToken);

        topItemsUseCaseInteractor.execute(topItemsInputData);
    }
}
