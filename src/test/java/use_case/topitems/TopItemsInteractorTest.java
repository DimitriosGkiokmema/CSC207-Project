package use_case.topitems;

import data_access.TopItemsDataAccessObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.top_items.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TopItemsInteractorTest {
    private TopItemsDataAccessInterface dummyObject;

    @BeforeEach
    public void setUp() {
        dummyObject = new TopItemsDataAccessObject();
    }

    @Test
    void successTest() {
        List<String> topTracks = new ArrayList<>();
        topTracks.add("Heartbreaker");
        topTracks.add("reincarnated");
        topTracks.add("Kill Bill");
        topTracks.add("Crew Love");

        List<String> topArtists = new ArrayList<>();
        topArtists.add("The Weeknd");
        topArtists.add("Kanye West");
        topArtists.add("A$AP Rocky");
        dummyObject.setCurrentTopTracks(topTracks);
        dummyObject.setCurrentTopArtists(topArtists);

        TopItemsOutputBoundary success = new TopItemsOutputBoundary() {
            @Override
            public void prepareSuccessView(TopItemsOutputData outputData) {
                assertEquals(topTracks, outputData.getTracks());
                assertEquals(topArtists, outputData.getArtists());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use Case failure is not expected");
            }
        };

        TopItemsInputBoundary topItemsInteractor = new TopItemsInteractor(dummyObject, success);
        topItemsInteractor.execute();
    }

    @Test
    void failTestForTopTracks() {
        List<String> topTracks = new ArrayList<>();

        List<String> topArtists = new ArrayList<>();
        topArtists.add("The Weeknd");
        topArtists.add("Kanye West");
        topArtists.add("A$AP Rocky");

        dummyObject.setCurrentTopTracks(topTracks);
        dummyObject.setCurrentTopArtists(topArtists);

        TopItemsOutputBoundary fail = new TopItemsOutputBoundary() {
            @Override
            public void prepareSuccessView(TopItemsOutputData outputData) {
                fail("User case success is not expected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Top Tracks cannot be determined", errorMessage);
            }
        };

        TopItemsInputBoundary topItemsInteractor = new TopItemsInteractor(dummyObject, fail);
        topItemsInteractor.execute();

    }

    @Test
    void failTestForTopArtists() {
        List<String> topTracks = new ArrayList<>();
        topTracks.add("Heartbreaker");
        topTracks.add("reincarnated");
        topTracks.add("Kill Bill");
        topTracks.add("Crew Love");

        List<String> topArtists = new ArrayList<>();

        dummyObject.setCurrentTopTracks(topTracks);
        dummyObject.setCurrentTopArtists(topArtists);

        TopItemsOutputBoundary fail = new TopItemsOutputBoundary() {
            @Override
            public void prepareSuccessView(TopItemsOutputData outputData) {
                fail("User case success is not expected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Top Artists cannot be determined", errorMessage);
            }
        };

        TopItemsInputBoundary topItemsInteractor = new TopItemsInteractor(dummyObject, fail);
        topItemsInteractor.execute();
    }

    @Test
    void failBoth() {
        List<String> topTracks = new ArrayList<>();

        List<String> topArtists = new ArrayList<>();

        dummyObject.setCurrentTopTracks(topTracks);
        dummyObject.setCurrentTopArtists(topArtists);

        TopItemsOutputBoundary fail = new TopItemsOutputBoundary() {
            @Override
            public void prepareSuccessView(TopItemsOutputData outputData) {
                fail("Use case success is not expected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Top Tracks and Top Artists cannot be determined", errorMessage);
            }
        };

        TopItemsInputBoundary topItemsInteractor = new TopItemsInteractor(dummyObject, fail);
        topItemsInteractor.execute();
    }

}
