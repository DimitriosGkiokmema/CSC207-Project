package interface_adapter.keyword;

import use_case.keyword.KeywordInputBoundary;
import use_case.keyword.KeywordInputData;

public class KeywordController {
    private final KeywordInputBoundary interactor;

    public KeywordController(KeywordInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void searchByKeyword(String artistName, String keyword) {
        if (artistName == null || artistName.isEmpty()) {
            throw new IllegalArgumentException("Artist name cannot be empty.");
        }
        if (keyword == null || keyword.isEmpty()) {
            throw new IllegalArgumentException("Keyword cannot be empty.");
        }

        // Pass input data to the interactor
        KeywordInputData inputData = new KeywordInputData(artistName, keyword);
        interactor.searchByKeyword(inputData);
    }
}