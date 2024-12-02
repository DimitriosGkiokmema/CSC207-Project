package data_access;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import entity.CommonUser;
import entity.CommonUserFactory;
import entity.UserFactory;
import entity.User;
import interface_adapter.login.LoginState;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.hc.core5.http.ParseException;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.enums.ModelObjectType;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.*;
import se.michaelthelin.spotify.requests.data.browse.GetRecommendationsRequest;
import se.michaelthelin.spotify.requests.data.follow.GetUsersFollowedArtistsRequest;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopArtistsRequest;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;
import use_case.login.LoginDataAccessInterface;
import use_case.recommend.RecommendDataAccessInterface;
import use_case.keyword.KeywordDataAccessInterface;
import use_case.similar_listeners.SimilarListenersDataAccessInterface;
import use_case.top_items.TopItemsDataAccessInterface;

/**
 * DAO for getting relevant information from Spotify API.
 */

public class SpotifyDataAccessObject implements TopItemsDataAccessInterface,
        SimilarListenersDataAccessInterface, RecommendDataAccessInterface, KeywordDataAccessInterface, LoginDataAccessInterface {
    public static final int OFFSET = 4;
    public static final int OFFSET2 = 0;

    private LoginState loginState = new LoginState();
    private String accessToken;
    private List<String> currentTopTracks;
    private List<String> currentTopArtists;
    private List<String> currentSearchResults;
    private SpotifyApi spotifyApi;
    private GetUsersTopTracksRequest getTopTracksRequest;
    private GetUsersTopArtistsRequest getTopArtistsRequest;

    private GetUsersFollowedArtistsRequest getUsersFollowedArtistsRequest;
    private static final ModelObjectType type = ModelObjectType.ARTIST;
    private List<String> currFollowedArtists;

    private GetRecommendationsRequest getRecommendationsRequest;

    public SpotifyDataAccessObject() {
        this.accessToken = "this should never be reached";
        this.spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        this.getTopTracksRequest = spotifyApi.getUsersTopTracks()
                .offset(OFFSET)
                .time_range("medium_term")
                .build();
        this.getTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .offset(OFFSET)
                .time_range("medium_term")
                .build();
        this.currentTopTracks = getUsersTopTracksSync();
        this.currentTopArtists = getUsersTopArtistsSync();

        this.getUsersFollowedArtistsRequest = spotifyApi.getUsersFollowedArtists(type).build();
        this.currFollowedArtists = getUsersFollowedArtistsSync();

        this.getRecommendationsRequest = spotifyApi.getRecommendations()
                .build();
    }

    // Constructor used for testing.
    public SpotifyDataAccessObject(String accessToken) {
        this.accessToken = accessToken;
        this.spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        this.getTopTracksRequest = spotifyApi.getUsersTopTracks()
                .offset(OFFSET)
                .time_range("medium_term")
                .build();
        this.getTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .offset(OFFSET2)
                .time_range("medium_term")
                .build();
        this.currentTopTracks = getUsersTopTracksSync();
        this.currentTopArtists = getUsersTopArtistsSync();

        this.getUsersFollowedArtistsRequest = spotifyApi.getUsersFollowedArtists(type).build();
        this.currFollowedArtists = getUsersFollowedArtistsSync();

        this.getRecommendationsRequest = spotifyApi.getRecommendations()
                .build();
    }

    /**
     * A helper method to get the current users top tracks.
     *
     * @return a list of the track names.
     */
    private List<String> getUsersTopTracksSync() {
        try {
            // Using Spotify Wrapper to get the given users top tracks from API
            final Paging<Track> trackPaging = getTopTracksRequest.execute();

            final Track[] tracks = trackPaging.getItems();

            final List<String> topTracks = new ArrayList<String>();
            for (Track track : tracks) {
                topTracks.add(track.getName());
            }
            // System.out.println("Top Tracks: " + topTracks);
            return topTracks;

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * A helper method to get the current users top artists.
     *
     * @return a list of the artist names.
     */
    private List<String> getUsersTopArtistsSync() {
        try {
            // Using Spotify Wrapper to get the given users top artists from API
            final Paging<Artist> artistPaging = getTopArtistsRequest.execute();

            final Artist[] artists = artistPaging.getItems();

            final List<String> topArtists = new ArrayList<>();
            for (Artist artist : artists) {
                topArtists.add(artist.getName());
            }
            // System.out.println("Top Artists: " + topArtists);
            return topArtists;

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    /**
     * A helper method to get the current users followed artists.
     * @return a list of the artists names.
     */
    private List<String> getUsersFollowedArtistsSync() {
        try {
            final PagingCursorbased<Artist> artistPagingCursorbased = getUsersFollowedArtistsRequest.execute();
            final Artist[] artists = artistPagingCursorbased.getItems();
            final List<String> followedArtists = new ArrayList<>();
            for (Artist artist : artists) {
                followedArtists.add(artist.getName());
            }
            // System.out.println(followedArtists);
            return followedArtists;
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }

    }

    @Override
    public List<String> getCurrentTopTracks() {
        // Used for testing
//        List<String> topTracks = new ArrayList<>();
//        topTracks.add("(sic)");
//        topTracks.add("Left Behind");
//        topTracks.add("Spit It Out");
//        topTracks.add("People = Shit");
//        topTracks.add("Metabolic");
//        topTracks.add("Everything Ends");
//        return topTracks;
        return currentTopTracks;
    }

    /**
     * A helper method to get the current users search results from spotify.
     * @param artistName the name of the artist the user is searching for.
     * @param keyword the keyword search the user is making.
     */
    private void getSearchResultsSync(String artistName, String keyword) {
        final String SEARCH_URL = "https://api.spotify.com/v1/search";
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
                List<String> songs = new ArrayList<String>();

                // Extract tracks from the response
                jsonObject.getAsJsonObject("tracks").getAsJsonArray("items").forEach(track -> {
                    String songName = track.getAsJsonObject().get("name").getAsString();
                    songs.add(songName); // Add the track name to the list
                });
                currentSearchResults = songs;
            } else {
                throw new RuntimeException("Failed to search songs: " + response.message());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error searching songs", e);
        }
    }

    @Override
    public List<String> getCurrentTopTracks2() {
        return currentTopTracks;
    }

    @Override
    public void setCurrentTopTracks2(List<String> tracks) {
        currentTopTracks = tracks;
    }

    @Override
    public List<String> getCurrentTopArtists2() {
        return currentTopArtists;
    }

    @Override
    public void setCurrentTopArtists2(List<String> artists) {
        this.currentTopArtists = artists;
    }

    @Override
    public void setCurrentTopTracks(List<String> tracks) {
        this.currentTopTracks = tracks;
    }

    @Override
    public List<String> getCurrentTopArtists() {
        // Used for testing
//        List<String> topArtists = new ArrayList<>();
//        topArtists.add("Slipknot");
//        topArtists.add("Soulfly");
//        topArtists.add("Korn");
//        topArtists.add("(Sepultura)");
//        topArtists.add("System Of A Down");
//        return topArtists;
        return currentTopArtists;
    }


    @Override
    public void setCurrentTopArtists(List<String> artists) {
        this.currentTopArtists = artists;
    }

    @Override
    public List<String> getFollowedArtists() {
        return this.currFollowedArtists;
    }

    @Override
    public void setCurrentFollowedArtists(List<String> followedArtists) {
        this.currFollowedArtists = followedArtists;

    }

    @Override
    public List<String> fetchSongs(String artist, String keyword) {
        return List.of();
    }

    @Override
    public List<String> searchSongs(String artistName, String keyword) {
        getSearchResultsSync(artistName, keyword);
        return getCurrentSearchResults();
    }

    public List<String> getCurrentSearchResults() {
        return currentSearchResults;
    }

    public void setCurrentSearchResults(List<String> currentSearchResults) {
        this.currentSearchResults = currentSearchResults;
    }

    @Override
    public void setAccessToken(String newToken) {
        this.accessToken = newToken;

        this.spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        this.getTopTracksRequest = spotifyApi.getUsersTopTracks()
                .offset(OFFSET)
                .time_range("medium_term")
                .build();
        this.getTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .offset(OFFSET2)
                .time_range("medium_term")
                .build();
        this.currentTopTracks = getUsersTopTracksSync();
        this.currentTopArtists = getUsersTopArtistsSync();

        this.getUsersFollowedArtistsRequest = spotifyApi.getUsersFollowedArtists(type).build();
        this.currFollowedArtists = getUsersFollowedArtistsSync();

        this.getRecommendationsRequest = spotifyApi.getRecommendations()
                .build();

        getUsersFollowedArtistsSync();
        getUsersTopArtistsSync();
        getUsersTopTracksSync();

    }

    @Override
    public boolean checkAccessToken(String testToken) {
        String oldToken = accessToken;
        setAccessToken(testToken);
        List<String> output = getUsersTopTracksSync();
        setAccessToken(oldToken);
        if (output.size() == 0){
            return false;
        }
        return true;
    }
}

