package use_case.recommend;

import entity.User;

/**
 * The Recommendations Interactor.
 */
public class RecommendInteractor implements RecommendInputBoundary {
    private final RecommendUserDataAcessInterface recommendDataAccessObject;
    private final RecommendOutputBoundary recommendPresenter;

    public RecommendInteractor(RecommendUserDataAcessInterface recommendDataAccessInterface,
                           RecommendOutputBoundary recommendOutputBoundary) {
        this.recommendDataAccessObject = recommendDataAccessInterface;
        this.recommendPresenter = recommendOutputBoundary;
    }

    @Override
    public void execute(RecommendInputData recommendInputData) {
        final String accessToken = recommendInputData.getAccessToken();
        if (!recommendDataAccessObject.existsByName(username)) {
            recommendPresenter.prepareFailView(username + ": Account does not exist.");
        }
        else {
            final String accessToken = recommendDataAccessObject.get(username).getName();
            final User user = userDataAccessObject.get(loginInputData.getLoginToken());
            userDataAccessObject.setCurrentUsername(user.getName());
            final LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);
            loginPresenter.prepareSuccessView(loginOutputData);
        }
    }
}
