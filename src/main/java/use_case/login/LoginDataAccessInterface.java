package use_case.login;

public interface LoginDataAccessInterface {
    void setAccessToken(String newToken);
    boolean checkAccessToken(String testToken);
}
