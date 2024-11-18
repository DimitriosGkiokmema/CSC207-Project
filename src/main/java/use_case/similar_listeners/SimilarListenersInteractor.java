package use_case.similar_listeners;

public class SimilarListenersInteractor implements SimilarListenersInputBoundary {
    private final SimilarListenersUserDataAccessInterface userDataAccessObject;
    private final SimilarListenersOutputBoundary loginPresenter;

    public SimilarListenersInteractor(SimilarListenersUserDataAccessInterface userDataAccessInterface,
                                      SimilarListenersOutputBoundary similarListenersOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = similarListenersOutputBoundary;
    }

    @Override
    public void execute(SimilarListenersInputData similarListenersInputData) {

    }
}
