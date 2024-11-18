package use_case.login;

import entity.User;

/**
 * The Login Interactor.
 */
public class LoginInteractor implements LoginInputBoundary {
    private final LoginUserDataAccessInterface userDataAccessObject;
    private final LoginOutputBoundary loginPresenter;

    public LoginInteractor(LoginUserDataAccessInterface userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        final String username = loginInputData.getLoginToken();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        }
        else {
            // final String pwd = userDataAccessObject.get(username).getName();
            final User user = userDataAccessObject.get(loginInputData.getLoginToken());
            userDataAccessObject.setCurrentAccessToken(user.getAccessToken());
            final LoginOutputData loginOutputData = new LoginOutputData(user.getAccessToken(), false);
            loginPresenter.prepareSuccessView(loginOutputData);
        }
    }
}
