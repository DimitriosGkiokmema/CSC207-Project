package use_case.top_items;

import java.util.List;

/**
 * The Input Data for the TopItems Use Case.
 */
public class TopItemsInputData {
    private String accessToken;

    public TopItemsInputData(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }
}
