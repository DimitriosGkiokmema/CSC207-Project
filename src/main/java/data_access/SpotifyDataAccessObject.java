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
import se.michaelthelin.spotify.enums.ModelObjectType;
import se.michaelthelin.spotify.exceptions.SpotifyWebApiException;
import se.michaelthelin.spotify.model_objects.specification.Artist;
import se.michaelthelin.spotify.model_objects.specification.Paging;
import se.michaelthelin.spotify.model_objects.specification.PagingCursorbased;
import se.michaelthelin.spotify.model_objects.specification.Track;
import se.michaelthelin.spotify.requests.data.follow.GetUsersFollowedArtistsRequest;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopArtistsRequest;
import se.michaelthelin.spotify.requests.data.personalization.simplified.GetUsersTopTracksRequest;
import use_case.similar_listeners.SimilarListenersUserDataAccessInterface;
import use_case.top_items.TopItemsUserDataAccessInterface;

/**
 * DAO for getting relevant information from Spotify API.
 */
public class SpotifyDataAccessObject implements TopItemsUserDataAccessInterface,
        SimilarListenersUserDataAccessInterface {
    public static final int OFFSET = 4;

    private LoginState loginState = new LoginState();
    private String accessToken;
    private List<String> currentTopTracks;
    private List<String> currentTopArtists;
    private SpotifyApi spotifyApi;
    private GetUsersTopTracksRequest getTopTracksRequest;
    private GetUsersTopArtistsRequest getTopArtistsRequest;

    private GetUsersFollowedArtistsRequest getUsersFollowedArtistsRequest;
    private static final ModelObjectType type = ModelObjectType.ARTIST;
    private List<String> currFollowedArtists;

    public SpotifyDataAccessObject() {
        this.accessToken = loginState.getLoginToken();
        this.spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        this.getTopTracksRequest = spotifyApi.getUsersTopTracks()
                .offset(OFFSET)
                .time_range("short_term")
                .build();
        this.getTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .offset(OFFSET)
                .time_range("short_term")
                .build();
        this.currentTopTracks = getUsersTopTracksSync();
        this.currentTopArtists = getUsersTopArtistsSync();

        this.getUsersFollowedArtistsRequest = spotifyApi.getUsersFollowedArtists(type).build();
        this.currFollowedArtists = getUsersFollowedArtistsSync();
    }

    // Constructor used for testing.
    public SpotifyDataAccessObject(String accessToken) {
        this.accessToken = accessToken;
        this.spotifyApi = new SpotifyApi.Builder()
                .setAccessToken(accessToken)
                .build();
        this.getTopTracksRequest = spotifyApi.getUsersTopTracks()
                .offset(OFFSET)
                .time_range("short_term")
                .build();
        this.getTopArtistsRequest = spotifyApi.getUsersTopArtists()
                .offset(OFFSET)
                .time_range("short_term")
                .build();
        this.currentTopTracks = getUsersTopTracksSync();
        this.currentTopArtists = getUsersTopArtistsSync();

        this.getUsersFollowedArtistsRequest = spotifyApi.getUsersFollowedArtists(type).build();
        this.currFollowedArtists = getUsersFollowedArtistsSync();
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
            //System.out.println("Top Tracks: " + topTracks);
            return topTracks;

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
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
            //System.out.println("Top Artists: " + topArtists);
            return topArtists;

        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
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
            return followedArtists;
        } catch (IOException | SpotifyWebApiException | ParseException e) {
            System.out.println("Error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public List<String> getCurrentTopTracks() {
        return this.currentTopTracks;
    }

    @Override
    public void setCurrentTopTracks(List<String> tracks) {
        this.currentTopTracks = tracks;
    }

    @Override
    public List<String> getCurrentTopArtists() {
        return this.currentTopArtists;
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
}

