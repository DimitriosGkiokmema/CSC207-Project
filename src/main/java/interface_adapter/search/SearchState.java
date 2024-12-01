package interface_adapter.search;

/**
 * The state for the SearchViewModel.
 */
public class SearchState {

    private String displayText;
    private String accessToken;

    public SearchState(SearchState copy) {
        displayText = copy.displayText;
        accessToken = copy.accessToken;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SearchState() {

    }
    public String getDisplayText() {return displayText;}
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
