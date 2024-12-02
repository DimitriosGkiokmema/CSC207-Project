package use_case.keyword;

public interface KeywordInputBoundary {

    /**
     * takes us to the keyword use case.
     */
    void execute();

    /**
     * Executes the keyword search use case.
     */
    void executeSearch(String artist, String keyword);

}