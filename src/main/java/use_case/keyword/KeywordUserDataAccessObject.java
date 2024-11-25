package use_case.keyword;

import entity.User;
import use_case.login.LoginUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of LoginUserDataAccessInterface for the Keyword feature.
 */
public class KeywordUserDataAccessObject implements LoginUserDataAccessInterface {
    private final Map<String, User> userStore = new HashMap<>(); // Stores users by username
    private String currentAccessToken; // Stores the current session's access token

    @Override
    public boolean existsByName(String username) {
        return userStore.containsKey(username);
    }

    @Override
    public void save(User user) {

    }


    @Override
    public User get(String username) {
        return userStore.get(username);
    }

    @Override
    public String getCurrentAccessToken() {
        return currentAccessToken;
    }

    @Override
    public void setCurrentAccessToken(String accessToken) {
        this.currentAccessToken = accessToken;
    }
}