package use_case.similar_listeners;

import java.util.List;

public class SimilarListenersOutputData {

    private final List<String> similarArtists;
    private final boolean useCaseFailed;
    private String accessToken;

    public SimilarListenersOutputData(List<String> similarArtists, boolean useCaseFailed, String accessToken) {
        this.similarArtists = similarArtists;
        this.useCaseFailed = useCaseFailed;
        this.accessToken = accessToken;
    }

    public List<String> getSimilarArtists() {
        return similarArtists;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
