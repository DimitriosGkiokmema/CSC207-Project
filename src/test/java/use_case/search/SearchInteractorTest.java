package use_case.search;
import data_access.SearchTestDataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class SearchInteractorTest {
    private SearchTestDataAccessObject dummyLanguageModel;

    @BeforeEach
    void setUp() {
         dummyLanguageModel = new SearchTestDataAccessObject();
    }

    @Test
    void querySuccess(){
        // This creates a successPresenter that tests whether the test case is as we expect.
        SearchOutputBoundary successPresenter = new SearchOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchOutputData outputData) {
                assertEquals("One Piece at a Time by Johnny Cash", outputData.getDisplayText());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        SearchInteractor interactor = new SearchInteractor(dummyLanguageModel, successPresenter);
        interactor.executeSearch("Generic Token", "A song in which a man steals a car part by part");
    }

    @Test
    void goToPageSuccess(){
        // This creates a successPresenter that tests whether the test case is as we expect.
        SearchOutputBoundary successPresenter = new SearchOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchOutputData outputData) {
                assertEquals("Generic Token", outputData.getAccessToken());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        SearchInteractor interactor = new SearchInteractor(dummyLanguageModel, successPresenter);
        interactor.execute("Generic Token");
    }

}
