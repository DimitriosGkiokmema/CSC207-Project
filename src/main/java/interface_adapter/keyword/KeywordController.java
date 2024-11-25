package interface_adapter.keyword;

import use_case.keyword.KeywordInputBoundary;
import use_case.keyword.KeywordInputData;

public class KeywordController {
    private final KeywordInputBoundary interactor;
    private final KeywordViewModel viewModel;

    public KeywordController(KeywordInputBoundary interactor, KeywordViewModel viewModel) {
        this.interactor = interactor;
        this.viewModel = viewModel;
    }

    public void searchByKeyword(String artistName, String keyword) {
        // Validate inputs
        if (artistName == null || artistName.isEmpty()) {
            viewModel.setErrorMessage("Artist name cannot be empty.");
            return; // Stop further execution
        }
        if (keyword == null || keyword.isEmpty()) {
            viewModel.setErrorMessage("Keyword cannot be empty.");
            return; // Stop further execution
        }

        // Clear any previous error messages
        viewModel.setErrorMessage(null);

        // Pass input data to the interactor
        KeywordInputData inputData = new KeywordInputData(artistName, keyword);
        interactor.searchByKeyword(inputData);
    }
}