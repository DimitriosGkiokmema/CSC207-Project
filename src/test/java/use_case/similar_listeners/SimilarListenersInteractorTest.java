package use_case.similar_listeners;

import data_access.SimilarListenersTestDataAccessObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SimilarListenersInteractorTest {

    @Test
    void successTest() {
        SimilarListenersInputData inputData = new SimilarListenersInputData("token");
        SimilarListenersDataAccessInterface accessObject = new SimilarListenersTestDataAccessObject();

        // For the success test, we need to add Paul to the data access repository before we log in.
        List<String> allfollowedArtists = new ArrayList<>();
        allfollowedArtists.add("Michael Jackson");
        allfollowedArtists.add("Drake");
        allfollowedArtists.add("Madonna");
        allfollowedArtists.add("Lady Gaga");
        allfollowedArtists.add("The Police");
        accessObject.setCurrentFollowedArtists(allfollowedArtists);

        // This creates a successPresenter that tests whether the test case is as we expect.
        SimilarListenersOutputBoundary successPresenter = new SimilarListenersOutputBoundary() {
            @Override
            public void prepareSuccessView(SimilarListenersOutputData outputData) {
                // check that the output data contains the username of who logged out
                assertEquals(allfollowedArtists, outputData.getSimilarArtists());
                assertEquals("Madonna", outputData.getSimilarArtists().get(2));
                assertEquals("token", outputData.getAccessToken());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        SimilarListenersInputBoundary interactor = new SimilarListenersInteractor(accessObject, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void failTest() {
        SimilarListenersInputData inputData = new SimilarListenersInputData("token");
        SimilarListenersDataAccessInterface accessObject = new SimilarListenersTestDataAccessObject();

        List<String> allfollowedArtists = new ArrayList<>();
        accessObject.setCurrentFollowedArtists(allfollowedArtists);

        SimilarListenersOutputBoundary successPresenter = new SimilarListenersOutputBoundary() {
            @Override
            public void prepareSuccessView(SimilarListenersOutputData outputData) {
                // check that the output data contains the username of who logged out
                fail("Use case success is unexpected.");
            }

            @Override
            public void prepareFailView(String error) {
                assertEquals("You do not follow any artists. "
                        + "Similar Listeners cannot be determined.", error);
            }
        };
        SimilarListenersInputBoundary interactor = new SimilarListenersInteractor(accessObject, successPresenter);
        interactor.execute(inputData);

    }
    @Test
    void tokenTest() {
        SimilarListenersOutputData outputData =
                new SimilarListenersOutputData(new ArrayList<>(), false, "token");
        outputData.setAccessToken("new token");
        assertEquals("new token", outputData.getAccessToken());

        }
    }


