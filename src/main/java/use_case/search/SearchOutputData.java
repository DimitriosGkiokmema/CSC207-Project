package use_case.search;
/**
 * Output Data for the Search Use Case.
 */
public class SearchOutputData {

    private String displayText;
    final private boolean useCaseFailed;

    public SearchOutputData(boolean useCaseFailed) {
        this.displayText = "This is where the response will appear.";
        this.useCaseFailed = useCaseFailed;

    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }


    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }
}
