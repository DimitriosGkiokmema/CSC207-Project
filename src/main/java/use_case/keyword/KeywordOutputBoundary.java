package use_case.keyword;

import use_case.search.SearchOutputData;
/**
 * The output boundary for the keyword Search Use Case.
 */
public interface KeywordOutputBoundary {
    /**
     * Prepares the success view for the keyword search Use Case.
     * @param outputData the output data
     */
    void prepareSuccessView(KeywordOutputData outputData);

    /**
     * Prepares the failure view for the keyword Search Use Case.
     * @param errorMessage the explanation of the failure
     */
    void prepareFailView(String errorMessage);

}