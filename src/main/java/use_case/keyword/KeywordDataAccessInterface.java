package use_case.keyword;

import java.util.List;

public interface KeywordDataAccessInterface {
    List<String> fetchSongs(String artist, String keyword);

    /** A method with searches for songs based on a given name and keyword about the song.
    * @param artistName the name of the artist to search for.
     * @param keyword a keyword about the song, possibly a lyric.
     * @return the related songs.
     */
    List<String> searchSongs(String artistName, String keyword);

}
