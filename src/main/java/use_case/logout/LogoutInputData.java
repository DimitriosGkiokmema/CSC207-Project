package use_case.logout;

/**
 * The Input Data for the Logout Use Case.
 */
public class LogoutInputData {
    private final String name;

    public LogoutInputData(String username) {
        this.name = username;
    }

    public String getName() {
        return name;
    }
}
