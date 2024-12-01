package interface_adapter.keyword;
/**
 * The state for the KeywordViewModel.
 */
public class KeywordState {
    private String displayText;
    private String accessToken;

    public KeywordState(KeywordState copy) {
        displayText = copy.displayText;
        accessToken = copy.accessToken;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public KeywordState() {

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
