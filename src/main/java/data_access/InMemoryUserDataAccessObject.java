package data_access;

import java.util.HashMap;
import java.util.Map;

import entity.User;
import use_case.login.LoginUserDataAccessInterface;
import use_case.logout.LogoutUserDataAccessInterface;

/**
 * In-memory implementation of the DAO for storing user data. This implementation does
 * NOT persist data between runs of the program.
 */
public class InMemoryUserDataAccessObject implements
        LoginUserDataAccessInterface,
        LogoutUserDataAccessInterface {
    private final Map<String, User> users = new HashMap<>();

    private String accessToken;

    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    @Override
    public void save(User user) {
        users.put(user.getAccessToken(), user);
    }

    @Override
    public User get(String username) {
        return users.get(username);
    }

    @Override
    public void setCurrentAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String getCurrentAccessToken() {
        return this.accessToken;
    }
}
