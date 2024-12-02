
package use_case.keyword;

/**
 * An interface for the Keyword Input Boundary.
 */
public interface KeywordInputBoundary {

    /**
     * Takes us to the keyword use case.
     */
    void execute();

    /**
     * Executes the keyword search use case.
     * @param artist the artist user input, may be null
     * @param keyword the keyword user input, may be null
     */
    void executeSearch(String artist, String keyword);
}
