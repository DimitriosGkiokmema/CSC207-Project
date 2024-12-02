package use_case.similar_listeners;

import java.util.List;

/**
 * The output data for the SimilarListeners Use Case.
 */
public class SimilarListenersOutputData {

    private final List<String> similarArtists;
    private final boolean useCaseFailed;

    public SimilarListenersOutputData(List<String> similarArtists, boolean useCaseFailed) {
        this.similarArtists = similarArtists;
        this.useCaseFailed = useCaseFailed;
    }

    public List<String> getSimilarArtists() {
        return similarArtists;
    }

}
