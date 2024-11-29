package interface_adapter.keyword;

import use_case.keyword.KeywordInputBoundary;
import use_case.keyword.KeywordInputData;

public class KeywordController {
    private final KeywordInputBoundary interactor;

    public KeywordController(KeywordInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void searchByKeyword(String artistName, String keyword) {
        // Validate inputs
        if (artistName == null || artistName.isEmpty()) {
            //viewModel.setErrorMessage("Artist name cannot be empty.");
            return; // Stop further execution
        }
        if (keyword == null || keyword.isEmpty()) {
            //viewModel.setErrorMessage("Keyword cannot be empty.");
            return; // Stop further execution
        }

        // Clear any previous error messages
        //viewModel.setErrorMessage(null);

        // Pass input data to the interactor
        KeywordInputData inputData = new KeywordInputData(artistName, keyword);
        interactor.searchByKeyword(inputData);
    }

    /**
     * Goes to the search use case.
     * @param accessToken the access token for spotify.
     */
    public void execute(String accessToken) {
        interactor.execute(accessToken);
    }

    /**
     * Executes the keyword Use Case.
     * @param keyword the keyword the user is inputting.
     * @param artist the artist the user wants info about.
     * @param accessToken the access token for spotify.
     */
    public void executeSearch(String accessToken, String artist, String keyword) {
        interactor.executeSearch(accessToken, artist, keyword);
    }
}