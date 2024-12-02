package interface_adapter.search;

/**
 * The state for the SearchViewModel.
 */
public class SearchState {

    private String displayText;

    public SearchState(SearchState copy) {
        displayText = copy.displayText;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public SearchState() {

    }
    public String getDisplayText() {return displayText;}
    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
