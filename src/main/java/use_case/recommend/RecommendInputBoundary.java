package use_case.recommend;

/**
 * Input Boundary for actions which are related to recommendations.
 */
public interface RecommendInputBoundary {

    /**
     * Executes the login use case.
     * @param recommendInputData the input data
     */
    void execute(RecommendInputData recommendInputData);
}
