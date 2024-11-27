package data_access;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpotifyDataAccessObjectTest {

    @Test
    void getCurrentTopTracksTest() {
        List<String> expected = new ArrayList();
        expected.add("Lovefool");
        expected.add("Надія є");
        SpotifyDataAccessObject dataAccessObject= new SpotifyDataAccessObject("BQDQP8XOnHL5-1B_9f7dvNJ1eN2Nj1rH6d4SZAjxfkZVZDHS-4R447KFvYGqFY4hhu2WgCscHg_egtYI-069ekDuy_MjFiIx9erWLJRYfg_mBaBwiN_DNfu9N9lUwXbz8OQ_WMnGtD5_GuCwC-b4CodFYQO3fGp1UKkkQbdyM_9qUStbGCnnxhr3IL_pDLJ8ny12eN9Pw5k1e1FjyZpLjjq7-xJV6TU");
        assertEquals(expected.get(0), dataAccessObject.getCurrentTopTracks().get(0));
        assertEquals(expected.get(1), dataAccessObject.getCurrentTopTracks().get(1));

    }

    @Test
    void getCurrentTopArtistsTest() {
        List<String> expected = new ArrayList();
        expected.add("Mad Heads");
        expected.add("Haydamaky");
        expected.add("Kozak System");
        SpotifyDataAccessObject dataAccessObject= new SpotifyDataAccessObject("BQDQP8XOnHL5-1B_9f7dvNJ1eN2Nj1rH6d4SZAjxfkZVZDHS-4R447KFvYGqFY4hhu2WgCscHg_egtYI-069ekDuy_MjFiIx9erWLJRYfg_mBaBwiN_DNfu9N9lUwXbz8OQ_WMnGtD5_GuCwC-b4CodFYQO3fGp1UKkkQbdyM_9qUStbGCnnxhr3IL_pDLJ8ny12eN9Pw5k1e1FjyZpLjjq7-xJV6TU");
        assertEquals(expected, dataAccessObject.getCurrentTopArtists());
    }
}