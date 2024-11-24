package use_case.keyword;

import java.util.List;

public class KeywordOutputData {
    private final List<String> songs;
    private final String errorMessage;

    // Constructor for successful results
    public KeywordOutputData(List<String> songs) {
        this.songs = songs;
        this.errorMessage = null;
    }

    // Constructor for errors
    public KeywordOutputData(String errorMessage) {
        this.songs = null;
        this.errorMessage = errorMessage;
    }

    public List<String> getSongs() {
        return songs;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean hasError() {
        return errorMessage != null;
    }
}