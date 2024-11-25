package use_case.top_items;

/**
 * The output boundary for the Top Tracks Use Case.
 */
public interface TopItemsOutputBoundary {

    /**
     * Prepares the success view for the Login Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(TopItemsOutputData outputData);

    /**
     * Prepares the failure view for the Login Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
