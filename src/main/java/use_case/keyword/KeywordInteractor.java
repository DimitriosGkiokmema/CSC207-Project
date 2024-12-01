package use_case.keyword;

import use_case.search.SearchOutputData;

import java.util.ArrayList;
import java.util.List;

/**
 * The interactor for the "Search by Keyword" use case.
 * Handles the business logic and interacts with the Spotify API service.
 */
public class KeywordInteractor implements KeywordInputBoundary {
    private final KeywordDataAccessInterface keywordDataAccessInterface; // Interacts with Spotify API
    private final KeywordOutputBoundary keywordPresenter; // Sends results to the presenter

    /**
     * Constructs a KeywordInteractor.
     *
     * @param keywordDataAccessInterface   The data_access.SpotifyDataAccessObject to handle API calls.
     * @param outputBoundary   The output boundary to send results or errors to the presenter.
     */
    public KeywordInteractor(KeywordDataAccessInterface keywordDataAccessInterface, KeywordOutputBoundary outputBoundary) {
        this.keywordDataAccessInterface = keywordDataAccessInterface;
        this.keywordPresenter = outputBoundary;
    }

    /**
     * Processes the input data, fetches song data from Spotify, and passes results to the output boundary.
     *
     * @param inputData Input data containing the artist's name and the keyword.
     */
    @Override
    public void searchByKeyword(KeywordInputData inputData) {
        try {
            String artistName = inputData.getArtistName();
            String keyword = inputData.getKeyword();

            // Use data_access.SpotifyService to fetch and filter songs
            List<String> songs = keywordDataAccessInterface.searchSongs(artistName, keyword);

            if (songs.isEmpty()) {
                // No songs found matching the keyword
                keywordPresenter.prepareSuccessView(new KeywordOutputData("No songs found matching the keyword."));
            } else {
                // Pass the list of songs to the presenter
                keywordPresenter.prepareSuccessView(new KeywordOutputData("placeholder token",songs));
            }
        } catch (Exception e) {
            // Pass any exception as an error message to the presenter
            keywordPresenter.prepareSuccessView(new KeywordOutputData("Error: " + e.getMessage()));
        }
    }

    @Override
    public void execute(String accessToken) {
        List<String> songs = new ArrayList<String>();
        songs.add("");
        final KeywordOutputData search = new KeywordOutputData(accessToken,songs);
        keywordPresenter.prepareSuccessView(search);
    }

    @Override
    public void executeSearch(String accessToken, String artist, String keyword){

        final List<String> songs = keywordDataAccessInterface.searchSongs(artist,keyword);
        final KeywordOutputData search = new KeywordOutputData(accessToken,songs);
        keywordPresenter.prepareSuccessView(search);
    }
}