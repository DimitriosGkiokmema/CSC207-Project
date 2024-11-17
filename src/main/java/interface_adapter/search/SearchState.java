package interface_adapter.search;

import interface_adapter.change_password.LoggedInState;

/**
 * The state for the SearchViewModel.
 */
public class SearchState {

    private String query;
    private String modelResponse;

    public SearchState(SearchState copy) {
        query = copy.query;
        modelResponse = copy.modelResponse;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SearchState() {

    }

    public String getQuery() {
        return query;
    }

    public String getModelResponse() {
        return modelResponse;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public void setModelResponse(String modelResponse) {
        this.modelResponse = modelResponse;
    }
}
