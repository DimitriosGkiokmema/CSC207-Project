package app;

import java.awt.*;

import javax.swing.*;

import data_access.InMemoryUserDataAccessObject;
import data_access.TopItemsUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import interface_adapter.recommend.RecommendController;
import interface_adapter.recommend.RecommendPresenter;
import interface_adapter.recommend.RecommendViewModel;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchPresenter;
import interface_adapter.search.SearchViewModel;
import interface_adapter.top_items.TopItemsController;
import interface_adapter.top_items.TopItemsPresenter;
import interface_adapter.top_items.TopItemsViewModel;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.recommend.RecommendInputBoundary;
import use_case.recommend.RecommendInteractor;
import use_case.recommend.RecommendOutputBoundary;
import use_case.recommend.RecommendUserDataAccessInterface;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.top_items.TopItemsInputBoundary;
import use_case.top_items.TopItemsInteractor;
import use_case.top_items.TopItemsOutputBoundary;
import view.LoggedInView;
import view.LoginView;
import view.RecommendationsView;
import view.SearchView;
import view.TopItemsView;
import view.ViewManager;

/**
 * The AppBuilder class is responsible for putting together the pieces of
 * our CA architecture; piece by piece.
 * <p/>
 * This is done by adding each View and then adding related Use Cases.
 */
// Checkstyle note: you can ignore the "Class Data Abstraction Coupling"
//                  and the "Class Fan-Out Complexity" issues for this lab; we encourage
//                  your team to think about ways to refactor the code to resolve these
//                  if your team decides to work with this as your starter code
//                  for your final project this term.
public class AppBuilder {
    private final JPanel cardPanel = new JPanel();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final UserFactory userFactory = new CommonUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();
    private final RecommendUserDataAccessInterface recommendUserDataAccessInterface = new RecommendUserDataAccessInterface();
    private final TopItemsUserDataAccessObject topItemsUserDataAccessObject = new TopItemsUserDataAccessObject();

    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private TopItemsViewModel topTracksAndArtistsViewModel;
    private RecommendViewModel recommendViewModel;
    private SearchViewModel searchViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private SearchView searchView;
    private TopItemsView topItemsView;
    private RecommendationsView recommendationsView;


    public AppBuilder() {
        cardPanel.setLayout(cardLayout);
    }

    /**
     * Adds the Login View to the application.
     * @return this builder
     */
    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new LoginView(loginViewModel);
        cardPanel.add(loginView, loginView.getViewName());
        return this;
    }

    /**
     * Adds the Search View to the application.
     * @return this builder
     */
    public AppBuilder addSearchView() {
        searchViewModel = new SearchViewModel();
        searchView = new SearchView(searchViewModel);
        cardPanel.add(searchView, searchView.getViewName());
        return this;
    }

    /**
     * Adds the LoggedIn View to the application.
     * @return this builder
     */
    public AppBuilder addLoggedInView() {
        loggedInViewModel = new LoggedInViewModel();
        loggedInView = new LoggedInView(loggedInViewModel);
        cardPanel.add(loggedInView, loggedInView.getViewName());
        return this;
    }

    /**
     * Adds the Top Tracks and Artists View to the application.
     * @return this builder
     */
    public AppBuilder addTopTracksAndArtistsView() {
        topTracksAndArtistsViewModel = new TopItemsViewModel();
        topItemsView = new TopItemsView(topTracksAndArtistsViewModel);
        cardPanel.add(topItemsView, topItemsView.getViewName());
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLoginUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    /**
     * Adds the Recommend Use Case to the application.
     * @return this builder
     */
    public AppBuilder addRecommendUseCase() {
        final RecommendOutputBoundary recommendOutputBoundary =
                new RecommendPresenter(viewManagerModel, recommendViewModel);
        final RecommendInputBoundary recommendInteractor =
                new RecommendInteractor(recommendUserDataAccessInterface, recommendOutputBoundary);

        final RecommendController recommendController = new RecommendController(recommendInteractor);
        recommendationsView.setRecommendController(recommendController);
        return this;
    }

    /**
     * Adds the Login Use Case to the application.
     * @return this builder
     */
    /* public AppBuilder addTopTracksandArtistsUseCase() {
        final TopTracksOutputBoundary topTracksOutputBoundary = new TopTracksPresenter(viewManagerModel,
                topTracksAndArtistsViewModel, topTracksAndArtistsView);
        final TopTracksInputBoundary loginInteractor = new TopTracksInteractor(
                userDataAccessObject, topTracksOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    } */

    /**
     * Adds the Logout Use Case to the application.
     * @return this builder
     */
    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);

        final LogoutInputBoundary logoutInteractor =
                new LogoutInteractor(userDataAccessObject, logoutOutputBoundary);

        final LogoutController logoutController = new LogoutController(logoutInteractor);
        loggedInView.setLogoutController(logoutController);
        return this;
    }

    /**
     * Adds the Search Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSearchUseCase() {
        final SearchOutputBoundary searchOutputBoundary = new SearchPresenter(viewManagerModel,
                loggedInViewModel, searchViewModel);

        final SearchInputBoundary searchInteractor =
                new SearchInteractor(searchOutputBoundary);

        final SearchController searchController = new SearchController(searchInteractor);
        loggedInView.setSearchController(searchController);
        return this;
    }
      /**
     * Adds the Top Tracks and Artists Use Case to the application.
     * @return this builder
     */
    public AppBuilder addTopTracksAndArtistsUseCase() {
        final TopItemsOutputBoundary topItemsOutputBoundary = new TopItemsPresenter(viewManagerModel,
                topTracksAndArtistsViewModel);

        final TopItemsInputBoundary topItemsInputBoundary =
                new TopItemsInteractor(topItemsUserDataAccessObject, topItemsOutputBoundary);

        final TopItemsController topItemsController = new TopItemsController(topItemsInputBoundary);
        loggedInView.setTopTracksController(topItemsController);
        return this;
    }

    /**
     * Creates the JFrame for the application and initially sets the SignupView to be displayed.
     * @return the application
     */
    public JFrame build() {
        final JFrame application = new JFrame("CSC207 Project: Spotify Companion App");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        Trying to set default size to app, but its not working
//        application.setSize(Constants.APP_WIDTH, Constants.APP_HEIGHT);

        application.add(cardPanel);

        viewManagerModel.setState(recommendViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
