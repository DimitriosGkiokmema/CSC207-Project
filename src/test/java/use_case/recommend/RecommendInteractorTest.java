package use_case.recommend;

import data_access.RecommendTestDataAccessObject;
import data_access.RecommendUserDataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RecommendInteractorTest {
    private RecommendTestDataAccessObject dummySpotify;
    private List<String> topTracks;
    private String topArtists;

    @BeforeEach
     void setUp() {
        dummySpotify = new RecommendTestDataAccessObject();
        topTracks = dummySpotify.getTopTracks();
        topArtists = dummySpotify.getTopArtists();
    }

    @Test
    void successTest() {
        // This creates a successPresenter that tests whether the test case is as we expect.
        RecommendOutputBoundary successPresenter = new RecommendOutputBoundary() {
            @Override
            public void prepareSuccessView(RecommendOutputData outputData) {
                final String topArtists = "Slipknot, Soulfly, Korn, Sepultura, System Of A Down";
                // check that the output data contains the artist names
                assertEquals(topArtists, outputData.getTopArtists());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        RecommendInputBoundary interactor = new RecommendInteractor(dummySpotify, successPresenter);
        interactor.execute(new RecommendInputData(topTracks, topArtists, "token"));
    }

    @Test
    void failTest() {
        // Create empty track list and inputData object
        List<String> tracks = new ArrayList<>();
        RecommendInputData inputData = new RecommendInputData(tracks, topArtists, "token");

        RecommendUserDataAccessInterface accessObject = new RecommendUserDataAccessObject();
        accessObject.setTopTracks(tracks);

        RecommendOutputBoundary successPresenter = new RecommendOutputBoundary() {
            @Override
            public void prepareSuccessView(RecommendOutputData outputData) {
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("Error getting tracks from Spotify", error);
            }
        };
        RecommendInputBoundary interactor = new RecommendInteractor(accessObject, successPresenter);
        interactor.execute(inputData);

    }
}
