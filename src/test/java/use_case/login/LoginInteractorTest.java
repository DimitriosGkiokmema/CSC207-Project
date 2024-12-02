package use_case.login;

import data_access.InMemoryUserDataAccessObject;
import data_access.LoginTestDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInteractorTest {

    @Test
    void successTest() {
        LoginInputData inputData = new LoginInputData("Generic token");
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();
        LoginTestDataAccessObject spotify = new LoginTestDataAccessObject();

        // For the success test, we need to add Paul to the data access repository before we log in.
        UserFactory factory = new CommonUserFactory();
        User user = factory.create("Generic token");
        userRepository.save(user);

        // This creates a successPresenter that tests whether the test case is as we expect.
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals("Generic token", user.getAccessToken());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository, spotify, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    void successUserLoggedInTest() {
        LoginTestDataAccessObject spotify = new LoginTestDataAccessObject();
        LoginInputData inputData = new LoginInputData("Generic token");
        LoginUserDataAccessInterface userRepository = new InMemoryUserDataAccessObject();

        // For the success test, we need to add Paul to the data access repository before we log in.
        UserFactory factory = new CommonUserFactory();
        User user = factory.create("Generic token");
        userRepository.save(user);

        // This creates a successPresenter that tests whether the test case is as we expect.
        LoginOutputBoundary successPresenter = new LoginOutputBoundary() {
            @Override
            public void prepareSuccessView(LoginOutputData user) {
                assertEquals("Generic token", userRepository.getCurrentAccessToken());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        LoginInputBoundary interactor = new LoginInteractor(userRepository,spotify, successPresenter);
        assertEquals(null, userRepository.getCurrentAccessToken());

        interactor.execute(inputData);
    }

}