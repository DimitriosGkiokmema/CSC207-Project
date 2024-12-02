package data_access;

import use_case.login.LoginDataAccessInterface;

public class LoginTestDataAccessObject implements LoginDataAccessInterface {
    @Override
    public void setAccessToken(String newToken) {

    }

    @Override
    public boolean checkAccessToken(String token) {
        return true;
    }
}
