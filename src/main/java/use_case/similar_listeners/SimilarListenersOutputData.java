package use_case.similar_listeners;

import java.util.List;

public class SimilarListenersOutputData {

    private List<String> similarArtists;

    public SimilarListenersOutputData(List<String> similarArtists) {
        this.similarArtists = similarArtists;
    }

    public List<String> getSimilarArtists() {
        return similarArtists;
    }
}
