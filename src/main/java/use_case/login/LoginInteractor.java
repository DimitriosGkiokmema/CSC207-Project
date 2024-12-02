package use_case.login;

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
        final String token = loginInputData.getLoginToken();
        userDataAccessObject.setCurrentAccessToken(token);
        final LoginOutputData loginOutputData = new LoginOutputData(token, false);
        loginPresenter.prepareSuccessView(loginOutputData);
    }
}
