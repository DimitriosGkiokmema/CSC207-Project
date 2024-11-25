package use_case.keyword;

import spotify_api.SpotifyService;

import java.util.List;

/**
 * The interactor for the "Search by Keyword" use case.
 * Handles the business logic and interacts with the Spotify API service.
 */
public class KeywordInteractor implements KeywordInputBoundary {
    private final SpotifyService spotifyService; // Interacts with Spotify API
    private final KeywordOutputBoundary outputBoundary; // Sends results to the presenter

    /**
     * Constructs a KeywordInteractor.
     *
     * @param spotifyService   The SpotifyService to handle API calls.
     * @param outputBoundary   The output boundary to send results or errors to the presenter.
     */
    public KeywordInteractor(SpotifyService spotifyService, KeywordOutputBoundary outputBoundary) {
        this.spotifyService = spotifyService;
        this.outputBoundary = outputBoundary;
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

            // Use SpotifyService to fetch and filter songs
            List<String> songs = spotifyService.searchSongs(artistName, keyword);

            if (songs.isEmpty()) {
                // No songs found matching the keyword
                outputBoundary.presentResults(new KeywordOutputData("No songs found matching the keyword."));
            } else {
                // Pass the list of songs to the presenter
                outputBoundary.presentResults(new KeywordOutputData(songs));
            }
        } catch (Exception e) {
            // Pass any exception as an error message to the presenter
            outputBoundary.presentResults(new KeywordOutputData("Error: " + e.getMessage()));
        }
    }
}