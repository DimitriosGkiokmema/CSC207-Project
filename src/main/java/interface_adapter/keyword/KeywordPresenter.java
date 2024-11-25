package interface_adapter.keyword;

import use_case.keyword.KeywordOutputBoundary;
import use_case.keyword.KeywordOutputData;

public class KeywordPresenter implements KeywordOutputBoundary {
    private final KeywordViewModel viewModel;

    public KeywordPresenter(KeywordViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void presentResults(KeywordOutputData outputData) {
        if (outputData.hasError()) {
            viewModel.setErrorMessage(outputData.getErrorMessage());
        } else {
            viewModel.setSongs(outputData.getSongs());
        }
        viewModel.setLoading(false);
    }
}