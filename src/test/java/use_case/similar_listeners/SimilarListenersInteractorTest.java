package use_case.similar_listeners;

import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;
import use_case.logout.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimilarListenersInteractorTest {

    @Test
    void successTest() {
        SimilarListenersInputData inputData = new SimilarListenersInputData("BQCOFgyHIg-eAjqOM8ITkCEynoZwEoN2__Sccimaakn2rZjBzIBTwSVK391IUAD7umWe6vvEE9MiiqvN6j1jFySdxecxQL0gS1Tt2y3DAlrt6c6XlfD6jEQJPiNqyOHueQr9ZQe4Um0A6Bz2cbKvzi-fW1MQG19K2rmT_Z0rLFQY-p3S9ssF-5213Ol_hAvpB0kORgMoazMdzPYe6A");
        InMemoryUserDataAccessObject userRepository = new InMemoryUserDataAccessObject();

        // For the success test, we need to add Paul to the data access repository before we log in.
        UserFactory factory = new CommonUserFactory();
        User user = factory.create("Paul", "password");
        userRepository.save(user);
        userRepository.setCurrentUsername("Paul");

        // This creates a successPresenter that tests whether the test case is as we expect.
        LogoutOutputBoundary successPresenter = new LogoutOutputBoundary() {
            @Override
            public void prepareSuccessView(LogoutOutputData user) {
                // check that the output data contains the username of who logged out
                assertEquals("Paul", user.getUsername());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        LogoutInputBoundary interactor = new LogoutInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
        // check that the user was logged out
        assertNull(userRepository.getCurrentUsername());
    }

}
