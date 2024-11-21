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
     * @param toptracks the top tracks of the user.
     * @param time the timespan of the data.
     * @param topartists the top artists of the user.
     */
    public void execute(List<String> toptracks, List<String> topartists, List<String> time) {
        // 1. instantiate the `LogoutInputData`, which should contain the username.
        // 2. tell the Interactor to execute.
        final TopItemsInputData topItemsInputData = new TopItemsInputData(toptracks, topartists, time);
        topItemsInputBoundary.execute(topItemsInputData);
    }
}
