package interface_adapter.keyword;

import java.util.List;

public class KeywordState {
    private boolean isLoading;
    private List<String> songs;
    private String errorMessage;

    // Constructor to initialize default state
    public KeywordState() {
        this.isLoading = false;
        this.songs = null;
        this.errorMessage = null;
    }

    // Getter and Setter for isLoading
    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    // Getter and Setter for songs
    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    // Getter and Setter for errorMessage
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Helper methods
    public boolean hasError() {
        return errorMessage != null;
    }

    public boolean hasResults() {
        return songs != null && !songs.isEmpty();
    }
}