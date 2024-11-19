package entity;

/**
 * Factory for creating CommonUser objects.
 */
public class CommonUserFactory implements UserFactory {

    @Override
    public User create(String accessToken) {
        return new CommonUser(accessToken);
    }
}
