
package use_case.keyword;

import java.util.ArrayList;
import java.util.List;

/**
 * The interactor for the "Search by Keyword" use case.
 * Handles the business logic and interacts with the Spotify API service.
 */
public class KeywordInteractor implements KeywordInputBoundary {
    /**
     * Interacts with Spotify API.
     */
    private final KeywordDataAccessInterface keywordDataAccessInterface;

    /**
     * Sends results to the presenter.
     */
    private final KeywordOutputBoundary keywordPresenter;

    /**
     * Constructs a KeywordInteractor.
     *
     * @param keywordDataAccessInterface The data access object to handle API calls, must not be null.
     * @param outputBoundary             The output boundary to send results or errors to the presenter, must not be
     *                                  null.
     */
    public KeywordInteractor(KeywordDataAccessInterface keywordDataAccessInterface,
                             KeywordOutputBoundary outputBoundary) {
        this.keywordDataAccessInterface = keywordDataAccessInterface;
        this.keywordPresenter = outputBoundary;
    }

    @Override
    public void execute() {
        final List<String> songs = new ArrayList<>();
        songs.add("");
        final KeywordOutputData search = new KeywordOutputData(songs);
        keywordPresenter.prepareSuccessView(search);
    }

    @Override
    public void executeSearch(String artist, String keyword) {
        if ((artist == null || artist.trim().isEmpty()) && (keyword == null || keyword.trim().isEmpty())) {
            keywordPresenter.prepareFailView("Error: Artist and keyword cannot both be empty.");
        }
        else {
            final List<String> songs = keywordDataAccessInterface.searchSongs(artist, keyword);
            final KeywordOutputData search = new KeywordOutputData(songs);
            keywordPresenter.prepareSuccessView(search);
        }
    }
}
