package interface_adapter.top_items;

import use_case.top_items.TopItemsInputBoundary;
import use_case.top_items.TopItemsInputData;

import java.util.List;

/**
 * The controller for the TopTracks and Artists Use Case.
 */
public class TopItemsController {
    private TopItemsInputBoundary topItemsUseCaseInteractor;

    public TopItemsController(TopItemsInputBoundary topItemsUseCaseInteractor) {
        this.topItemsUseCaseInteractor = topItemsUseCaseInteractor;
    }

    /**
     * Executes the TopItems Use Case.
     * @param toptracks the top tracks of the user.
     * @param topartists the top artists of the user.
     */
    public void execute(List<String> toptracks, List<String> topartists) {
        final TopItemsInputData topItemsInputData = new TopItemsInputData(toptracks, topartists);

        topItemsUseCaseInteractor.execute(topItemsInputData);
    }
}
