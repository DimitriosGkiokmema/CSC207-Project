package data_access;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entity.CommonUser;
import entity.User;

import interface_adapter.login.LoginState;
import org.apache.hc.core5.http.ParseException;
import org.json.JSONException;
import org.json.JSONObject;
import se.michaelthelin.spotify.SpotifyApi;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopArtistsRequest;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;
import use_case.top_items.TopItemsUserDataAccessInterface;

/**
 * DAO for getting relevant information from Spotify API.
 */
public class SpotifyDataAccessObject implements TopItemsUserDataAccessInterface {

    private LoginState loginState = new LoginState();
    private String accessToken;
    private User currentUser;
    private SpotifyApi spotifyApi;
    private GetUsersTopTracksRequest getTopTracksRequest;
    private GetUsersTopArtistsRequest getTopArtistsRequest;

    public SpotifyDataAccessObject() {
        this.accessToken = loginState.getLoginToken();
        //this.accessToken = accessToken;
        this.currentUser = new CommonUser(accessToken);
        this.spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        this.getTopTracksRequest = spotifyApi.getUsersTopTracks()
                .build();
        this.getTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .build();
    }

    // Constructor used for testing.
    public SpotifyDataAccessObject(String accessToken) {
        this.accessToken = accessToken;
        this.currentUser = new CommonUser(accessToken);
        this.spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        this.getTopTracksRequest = spotifyApi.getUsersTopTracks()
                .build();
        this.getTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .build();
    }

    /**
     * A helper method to get the current users top tracks.
     * @return a list of the track names.
     */
    private List<String> getUsersTopTracksSync() {
        try {
            // Using Spotify Wrapper to get the given users top tracks from API
            final Paging<Track> trackPaging = getTopTracksRequest.execute();

            Track[] tracks = trackPaging.getItems();

            List<String> topTracks = new ArrayList<String>();
            for (Track track : tracks) {
                topTracks.add(track.getName());
            }
            System.out.println("Top Tracks: " + topTracks);
            return topTracks;

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    private List<String> getUsersTopArtistsSync() {
        try {
            // Using Spotify Wrapper to get the given users top artists from API
            final Paging<Artist> artistPaging = getTopArtistsRequest.execute();

            Artist[] artists = artistPaging.getItems();

            List<String> topArtists = new ArrayList<String>();
            for (Artist artist : artists) {
                topArtists.add(artist.getName());
            }
            System.out.println("Top Artists: " + topArtists);
            return topArtists;

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<String> getCurrentTopTracks() {
        return getUsersTopTracksSync();
    }

    @Override
    public void setCurrentTopTracks(List<String> tracks) {

    }

    @Override
    public List<String> getCurrentTopArtists() {
        return getUsersTopArtistsSync();
    }

    @Override
    public void setCurrentTopArtists(List<String> artists) {

    }

    @Override
    public List<String> getCurrentTime() {
        return List.of();
    }

    @Override
    public void setCurrentTime(List<String> time) {

    }

    public static void main(String[] args) {
        SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject("BQDQP8XOnHL5-1B_9f7dvNJ1eN2Nj1rH6d4SZAjxfkZVZDHS-4R447KFvYGqFY4hhu2WgCscHg_egtYI-069ekDuy_MjFiIx9erWLJRYfg_mBaBwiN_DNfu9N9lUwXbz8OQ_WMnGtD5_GuCwC-b4CodFYQO3fGp1UKkkQbdyM_9qUStbGCnnxhr3IL_pDLJ8ny12eN9Pw5k1e1FjyZpLjjq7-xJV6TU");
        spotifyDataAccessObject.getUsersTopTracksSync();
        spotifyDataAccessObject.getUsersTopArtistsSync();

    }

}

