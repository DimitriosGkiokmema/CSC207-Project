
package interface_adapter.keyword;

import use_case.keyword.KeywordInputBoundary;

public class KeywordController {
    private final KeywordInputBoundary interactor;

    public KeywordController(KeywordInputBoundary interactor) {
        this.interactor = interactor;
    }



    /**
     * Goes to the keyword use case page.
     */
    public void execute() {
        interactor.execute();
    }

    /**
     * Executes the keyword Use Case.
     *
     * @param artist the artist the user wants info about.
     * @param keyword the keyword the user wants info about.
     */
    public void executeSearch(String artist, String keyword) {
        interactor.executeSearch(artist, keyword);
    }
}