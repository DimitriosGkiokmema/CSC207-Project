package interface_adapter.top_items;

import use_case.top_items.TopItemsInputBoundary;
import use_case.top_items.TopItemsInputData;

import java.util.List;

/**
 * The controller for the TopTracks and Artists Use Case.
 */
public class TopItemsController {
    private TopItemsInputBoundary topItemsInputBoundary;

    public TopItemsController(TopItemsInputBoundary topItemsInputBoundary) {
        this.topItemsInputBoundary = topItemsInputBoundary;
    }

    /**
     * Executes the Logout Use Case.
     * @param toptracks the username of the user logging in
     * @param time nfvenprne
     */
    public void execute(List<String> toptracks, List<String> time) {
        // 1. instantiate the `LogoutInputData`, which should contain the username.
        // 2. tell the Interactor to execute.
        final TopItemsInputData topItemsInputData = new TopItemsInputData(toptracks, time);
        topItemsInputBoundary.execute(topItemsInputData);
    }
}
