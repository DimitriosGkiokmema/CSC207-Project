package use_case.recommend;

import data_access.RecommendTestDataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecommendInteractorTest {
    private RecommendTestDataAccessObject dummyDAO;
    private List<String> topArtists;

    @BeforeEach
     void setUp() {
        dummyDAO = new RecommendTestDataAccessObject();
        topArtists = dummyDAO.getCurrentTopArtists();
    }

    @Test
    void successTest() {
        // This creates a successPresenter that tests whether the test case is as we expect.
        RecommendOutputBoundary successPresenter = new RecommendOutputBoundary() {
            @Override
            public void prepareSuccessView(RecommendOutputData outputData) {
                // check that the output data contains the artist names
                assertEquals(topArtists, outputData.getCurrentTopArtists());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        RecommendInputBoundary interactor = new RecommendInteractor(dummyDAO, dummyDAO, successPresenter);
        interactor.execute(new RecommendInputData());
    }

    @Test
    void failTest() {
        // Create empty track list and inputData object
        List<String> tracks = new ArrayList<>();
        RecommendInputData inputData = new RecommendInputData();
        dummyDAO.setCurrentTopTracks(tracks);

        RecommendOutputBoundary successPresenter = new RecommendOutputBoundary() {
            @Override
            public void prepareSuccessView(RecommendOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Error: song tracks are not available.", error);
            }
        };

        RecommendInputBoundary interactor = new RecommendInteractor(dummyDAO, dummyDAO, successPresenter);
        interactor.execute(inputData);
    }
}
