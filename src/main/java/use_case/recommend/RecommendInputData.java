package use_case.recommend;

import java.util.List;
import java.util.Map;

/**
 * The Input Data for the Recommend Use Case.
 */
public class RecommendInputData {
    private final List<String> topTracks;
    private final String topArtists;
    private String accessToken;

    public RecommendInputData(List<String> topTracks, String topArtists, String accessToken) {
        this.topTracks = topTracks;
        this.topArtists = topArtists;
        this.accessToken = accessToken;
    }

    public List<String> getTopTracks() {
        return topTracks;
    }

    public String getTopArtists() {
        return topArtists;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
