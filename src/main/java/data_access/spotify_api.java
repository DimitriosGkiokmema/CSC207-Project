package spotify_api;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpotifyService {
    private static final String SEARCH_URL = "https://api.spotify.com/v1/search";
    private final String accessToken;

    public SpotifyService(String accessToken) {
        if (accessToken == null || accessToken.isEmpty()) {
            throw new IllegalArgumentException("Access token cannot be null or empty.");
        }
        this.accessToken = accessToken;
    }

    public List<String> searchSongs(String artistName, String keyword) {
        OkHttpClient client = new OkHttpClient();

        // Build the search query URL
        HttpUrl url = HttpUrl.parse(SEARCH_URL).newBuilder()
                .addQueryParameter("q", "artist:" + artistName + " " + keyword) // Combine artist and keyword
                .addQueryParameter("type", "track")
                .build();

        // Prepare the API request
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer " + accessToken) // Use the provided access token
                .get()
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                JsonObject jsonObject = JsonParser.parseString(response.body().string()).getAsJsonObject();
                List<String> songs = new ArrayList<>();

                // Extract tracks from the response
                jsonObject.getAsJsonObject("tracks").getAsJsonArray("items").forEach(track -> {
                    String songName = track.getAsJsonObject().get("name").getAsString();
                    songs.add(songName); // Add the track name to the list
                });

                return songs;
            } else {
                throw new RuntimeException("Failed to search songs: " + response.message());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error searching songs", e);
        }
    }
}
