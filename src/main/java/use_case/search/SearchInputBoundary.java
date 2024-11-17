package use_case.search;

import use_case.login.LoginInputData;

/**
 * Input Boundary for actions which are related to logging in.
 */
public interface SearchInputBoundary {
    /**
     * Executes the login use case.
     * @param loginInputData the input data
     */
    void execute(LoginInputData loginInputData);
}
