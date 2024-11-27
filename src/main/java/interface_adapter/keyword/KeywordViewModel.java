package interface_adapter.keyword;

import java.util.List;

public class KeywordViewModel {
    private boolean proper_input = false;
    private String errorMessage = null; // Error message starts as null
    private List<String> songs = null; // Song list starts as null

    // Getter for loading state
    public boolean isProper_input() {
        return proper_input;
    }

    // Setter for loading state
    public void setLoading(boolean proper_input) {
        this.proper_input = proper_input;
    }

    // Getter for error message
    public String getErrorMessage() {
        return errorMessage;
    }

    // Setter for error message
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getter for song list
    public List<String> getSongs() {
        return songs;
    }

    // Setter for song list
    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    // Helper method to determine if there is an error
    public boolean hasError() {
        return errorMessage != null && !errorMessage.isEmpty();
    }

    // Method to clear state when starting a new search
    public void reset() {
        this.proper_input = false;
        this.errorMessage = null;
        this.songs = null;
    }
}