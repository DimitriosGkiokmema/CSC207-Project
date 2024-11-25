package use_case.keyword;

public class KeywordInputData {
    private final String artistName;
    private final String keyword;

    public KeywordInputData(String artistName, String keyword) {
        this.artistName = artistName;
        this.keyword = keyword;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getKeyword() {
        return keyword;
    }
}