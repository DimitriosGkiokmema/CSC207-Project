package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

/**
 * The controller for the Login Use Case.
 */
public class LoginController {

    private final LoginInputBoundary loginUseCaseInteractor;

    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the Login Use Case.
     * @param loginToken the username of the user logging in
     */
    public void execute(String loginToken) {
        final LoginInputData loginInputData = new LoginInputData(
                loginToken);

        loginUseCaseInteractor.execute(loginInputData);
    }

    /**
     * Executes the Login Use Case without changing the token.
     */
    public void execute() {
        final LoginInputData loginInputData = new LoginInputData();

        loginUseCaseInteractor.execute(loginInputData);
    }

}
