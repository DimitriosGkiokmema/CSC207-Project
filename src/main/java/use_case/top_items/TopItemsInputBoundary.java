package use_case.top_items;

/**
 * Input Boundary for actions which are related to TopItems Charts.
 */
public interface TopItemsInputBoundary {

    /**
     * Executes the Logout use case.
     * @param topItemsInputData the input data
     */
    void execute(TopItemsInputData topItemsInputData);
}
