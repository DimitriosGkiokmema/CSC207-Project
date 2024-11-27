package use_case.similar_listeners;

public interface SimilarListenersInputBoundary {

    /**
     * Execute the similar listeners use case.
     * @param similarListenersInputData the input data.
     */
    void execute(SimilarListenersInputData similarListenersInputData);
}
