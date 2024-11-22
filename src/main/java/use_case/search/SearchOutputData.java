package use_case.search;
/**
 * Output Data for the Search Use Case.
 */
public class SearchOutputData {


    private boolean useCaseFailed;

    public SearchOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;

    }

    public boolean isUseCaseFailed() {
        return useCaseFailed;
    }
}
