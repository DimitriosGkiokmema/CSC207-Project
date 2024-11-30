package use_case.recommend;

import java.util.List;
import java.util.Map;

/**
 * The Input Data for the Recommend Use Case.
 */
public class RecommendInputData {
    private final List<String> topTracks;
    private final List<String> topArtists;
    private String accessToken;

    public RecommendInputData(List<String> topTracks, List<String> topArtists, String accessToken) {
        this.topTracks = topTracks;
        this.topArtists = topArtists;
        this.accessToken = accessToken;
    }

    public List<String> getTopTracks() {
        return topTracks;
    }

    public List<String> getTopArtists() {
        return topArtists;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
