package use_case.recommend;

import java.util.List;

/**
 * The output data for the Recommend Use Case.
 */
public class RecommendOutputData {
    private final String songRecommendations;
    private final List<String> topArtists;

    public RecommendOutputData(String songRecommendations, List<String> topArtists) {
        this.songRecommendations = songRecommendations;
        this.topArtists = topArtists;
    }

    public String getSongRecommendations() {
        return songRecommendations;
    }

    public List<String> getCurrentTopArtists() {
        return topArtists;
    }
}
