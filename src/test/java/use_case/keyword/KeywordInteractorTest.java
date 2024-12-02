
package use_case.keyword;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import data_access.KeywordTestDataAccessObject;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Keyword Search Use Case.
 */
public class KeywordInteractorTest {

    private KeywordInteractor keywordInteractor;
    private KeywordTestDataAccessObject testDataAccess;
    private MockKeywordPresenter mockPresenter;

    @BeforeEach
    public void setUp() {
        testDataAccess = new KeywordTestDataAccessObject();
        mockPresenter = new MockKeywordPresenter();
        keywordInteractor = new KeywordInteractor(testDataAccess, mockPresenter);
    }

    @Test
    public void testExecuteSearch_Success() {
        keywordInteractor.executeSearch("Taylor Swift", "Love");
        assertEquals(1, mockPresenter.successCount);
        assertEquals(0, mockPresenter.failCount);
        assertFalse(mockPresenter.latestOutputData.hasError());
        assertEquals("[Love Story]", mockPresenter.latestOutputData.getSongs());
    }

    @Test
    public void testExecuteSearch_Failure_EmptyInput() {
        keywordInteractor.executeSearch("", "");
        assertEquals(0, mockPresenter.successCount);
        assertEquals(1, mockPresenter.failCount);
        assertEquals("Error: Artist and keyword cannot both be empty.", mockPresenter.latestErrorMessage);
    }

    // Mock presenter class for testing
    private static class MockKeywordPresenter implements KeywordOutputBoundary {
        int successCount = 0;
        int failCount = 0;
        KeywordOutputData latestOutputData;
        String latestErrorMessage;

        @Override
        public void prepareSuccessView(KeywordOutputData outputData) {
            successCount++;
            latestOutputData = outputData;
        }

        @Override
        public void prepareFailView(String errorMessage) {
            failCount++;
            latestErrorMessage = errorMessage;
        }
    }
}


