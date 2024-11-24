package interface_adapter.keyword;

import java.util.List;

public class KeywordViewModel {
    private boolean isLoading = false;
    private String errorMessage = null;
    private List<String> songs = null;

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }

    public boolean hasError() {
        return false;
    }
}