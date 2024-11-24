package use_case.keyword;

public interface KeywordInputBoundary {
    /**
     * Initiates the search for songs by the given artist name and keyword.
     *
     * @param inputData The input data containing the artist's name and keyword.
     */
    void searchByKeyword(KeywordInputData inputData);
}