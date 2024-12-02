package use_case.login;

import java.io.IOException;

/**
 * The Login Interactor.
 */
public class LoginInteractor implements LoginInputBoundary {
    private final LoginUserDataAccessInterface userDataAccessObject;
    private final LoginDataAccessInterface loginDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface, LoginDataAccessInterface loginDataAccessObject,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginDataAccessObject = loginDataAccessObject;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        try {
            final String token = loginInputData.getAccessToken();
            if ( token.equals("noToken")) {
                final LoginOutputData loginOutputData = new LoginOutputData(false);
                loginPresenter.prepareSuccessView(loginOutputData);
            } else {
                if(!loginDataAccessObject.checkAccessToken(token)) {
                    throw new RuntimeException("Invalid token");
                }
                userDataAccessObject.setCurrentAccessToken(token);
                final LoginOutputData loginOutputData = new LoginOutputData(false);
                loginDataAccessObject.setAccessToken(token);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
        catch (Exception e) {
            loginPresenter.prepareFailView("Oops, the token you entered is either invalid or that user hasn't listened to any songs");
        }

    }
}
