package use_case.login;

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
            if (loginInputData.getLoginToken().equals("noToken")) {
                final LoginOutputData loginOutputData = new LoginOutputData(false);
                loginPresenter.prepareSuccessView(loginOutputData);
            } else {
                final String token = loginInputData.getLoginToken();
                userDataAccessObject.setCurrentAccessToken(token);
                final LoginOutputData loginOutputData = new LoginOutputData(false);
                loginDataAccessObject.setAccessToken(token);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
        catch (Exception e) {
            final LoginOutputData loginOutputData = new LoginOutputData(false);
            loginPresenter.prepareSuccessView(loginOutputData);
        }

    }
}
