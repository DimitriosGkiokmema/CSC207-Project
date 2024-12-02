
package use_case.keyword;

import java.util.List;

/**
 * An interface for accessing keyword-related data.
 */
public interface KeywordDataAccessInterface {

    /**
     * Searches for songs based on a given artist name and keyword about the song.
     *
     * @param artistName the name of the artist to search for, may be null
     * @param keyword a keyword about the song, possibly a lyric, may be null
     * @return the related songs
     */
    List<String> searchSongs(String artistName, String keyword);

}