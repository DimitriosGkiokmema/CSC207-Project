package use_case.keyword;

import java.util.List;

public class KeywordOutputData {
    private final List<String> songs;
    private final String errorMessage;
    private String spotifyToken;

    // Constructor for successful results
    public KeywordOutputData(List<String> songs) {
        this.songs = songs;
        this.errorMessage = null;
    }

    // Constructor for errors
    public KeywordOutputData(String errorMessage) {
        this.spotifyToken = "spotifyToken";
        this.songs = null;
        this.errorMessage = errorMessage;
    }

    public String getSongs() {
        return songs.toString();
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setSpotifyToken(String spotifyToken) {
        this.spotifyToken = spotifyToken;
    }
    public String getSpotifyToken() {
        return spotifyToken;
    }

    public boolean hasError() {
        return errorMessage != null;
    }

    public String getDisplayText() {
        return "";
    }
}