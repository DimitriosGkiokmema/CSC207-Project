package use_case.similar_listeners;

/**
 * The output boundary for the SimilarListeners Use Case.
 */
public interface SimilarListenersOutputBoundary {
    /**
     * Prepares the success view for the Similar Listeners Use Case.
     * @param similarListenersOutputData the output data
     */
    void prepareSuccessView(SimilarListenersOutputData similarListenersOutputData);

    /**
     * Prepares the failure view for the Similar Listeners Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);
}
