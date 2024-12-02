package app;

import java.awt.*;

import javax.swing.*;

import data_access.*;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.keyword.KeywordController;
import interface_adapter.keyword.KeywordPresenter;
import interface_adapter.keyword.KeywordViewModel;
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
import interface_adapter.similar_listeners.SimilarListenersController;
import interface_adapter.similar_listeners.SimilarListenersPresenter;
import interface_adapter.similar_listeners.SimilarListenersViewModel;
import interface_adapter.top_items.TopItemsController;
import interface_adapter.top_items.TopItemsPresenter;
import interface_adapter.top_items.TopItemsViewModel;
import use_case.keyword.KeywordInputBoundary;
import use_case.keyword.KeywordInteractor;
import use_case.keyword.KeywordOutputBoundary;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInteractor;
import use_case.login.LoginOutputBoundary;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import use_case.recommend.RecommendInputBoundary;
import use_case.recommend.RecommendInteractor;
import use_case.recommend.RecommendOutputBoundary;
import use_case.search.SearchInputBoundary;
import use_case.search.SearchInteractor;
import use_case.search.SearchOutputBoundary;
import use_case.similar_listeners.SimilarListenersInputBoundary;
import use_case.similar_listeners.SimilarListenersInteractor;
import use_case.similar_listeners.SimilarListenersOutputBoundary;
import use_case.top_items.TopItemsInputBoundary;
import use_case.top_items.TopItemsInteractor;
import use_case.top_items.TopItemsOutputBoundary;
import view.LoggedInView;
import view.LoginView;
import view.RecommendationsView;
import view.SearchView;
import view.TopItemsView;
import view.SimilarListenersView;

import view.ViewManager;
import view.*;

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
    private final LanguageModelDataAccessObject languageModelDataAccessObject = new LanguageModelDataAccessObject();
    private final RecommendUserDataAccessObject recommendUserDataAccessObject = new RecommendUserDataAccessObject();
    private final SpotifyDataAccessObject spotifyDataAccessObject = new SpotifyDataAccessObject();

    private LoginViewModel loginViewModel;
    private LoggedInViewModel loggedInViewModel;
    private TopItemsViewModel topTracksAndArtistsViewModel;
    private RecommendViewModel recommendViewModel;
    private SearchViewModel searchViewModel;
    private SimilarListenersViewModel similarListenersViewModel;
    private LoggedInView loggedInView;
    private LoginView loginView;
    private SearchView searchView;
    private TopItemsView topItemsView;
    private SimilarListenersView similarListenersView;
    private RecommendationsView recommendationsView;
    private KeywordView keywordView;
    private KeywordViewModel keywordViewModel;


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
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject,spotifyDataAccessObject, loginOutputBoundary);
        final LoginController loginController = new LoginController(loginInteractor);
        searchView.setLoginController(loginController);
        return this;
    }

    /**
     * Adds the Recommendation View to the application.
     * @return this builder
     */
    public AppBuilder addRecommendationsView() {
        recommendViewModel = new RecommendViewModel();
        recommendationsView = new RecommendationsView(recommendViewModel);
        cardPanel.add(recommendationsView, recommendationsView.getViewName());
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
    public AppBuilder addTopItemsView() {
        topTracksAndArtistsViewModel = new TopItemsViewModel();
        topItemsView = new TopItemsView(topTracksAndArtistsViewModel);
        cardPanel.add(topItemsView, topItemsView.getViewName());
        return this;
    }

    /**
     * Adds the SimilarListeners View to the application.
     * @return this builder
     */
    public AppBuilder addSimilarListenersView() {
        similarListenersViewModel = new SimilarListenersViewModel();
        similarListenersView = new SimilarListenersView(similarListenersViewModel);
        cardPanel.add(similarListenersView, similarListenersView.getViewName());
        return this;
    }

    /**
     * Adds the Keyword View to the application.
     * @return this builder
     */
    public AppBuilder addKeywordView() {
        keywordViewModel = new KeywordViewModel();
        keywordView = new KeywordView(keywordViewModel);
        cardPanel.add(keywordView, keywordView.getViewName());
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject,spotifyDataAccessObject, loginOutputBoundary);
        final LoginController loginController = new LoginController(loginInteractor);
        keywordView.setLoginController(loginController);
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
                userDataAccessObject,spotifyDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

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
     * Adds the Keyword Search Use Case to the application.
     * @return this builder
     */
    public AppBuilder addKeywordUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject,spotifyDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        keywordView.setLoginController(loginController);

        final KeywordOutputBoundary keywordOutputBoundary = new KeywordPresenter(viewManagerModel,
                loggedInViewModel, keywordViewModel);

        final KeywordInputBoundary keywordInteractor =
                new KeywordInteractor(spotifyDataAccessObject, keywordOutputBoundary);

        final KeywordController keywordController = new KeywordController(keywordInteractor);
        keywordView.setKeywordController(keywordController);
        loggedInView.setKeywordController(keywordController);
        return this;
    }
    /**
     * Adds the Search Use Case to the application.
     * @return this builder
     */
    public AppBuilder addSearchUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject,spotifyDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        searchView.setLoginController(loginController);

        final SearchOutputBoundary searchOutputBoundary = new SearchPresenter(viewManagerModel,
                loggedInViewModel, searchViewModel);

        final SearchInputBoundary searchInteractor =
                new SearchInteractor(languageModelDataAccessObject, searchOutputBoundary);

        final SearchController searchController = new SearchController(searchInteractor);
        searchView.setSearchController(searchController);
        loggedInView.setSearchController(searchController);
        return this;
    }

    /**
     * Adds the Top Tracks and Artists Use Case to the application.
     * @return this builder
     */
    public AppBuilder addTopItemsUseCase() {

        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject,spotifyDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        topItemsView.setLoginController(loginController);

        final TopItemsOutputBoundary topItemsOutputBoundary = new TopItemsPresenter(viewManagerModel,
                topTracksAndArtistsViewModel);

        final TopItemsInputBoundary topItemsInputBoundary =
                new TopItemsInteractor(spotifyDataAccessObject, topItemsOutputBoundary);

        final TopItemsController topItemsController = new TopItemsController(topItemsInputBoundary);
        loggedInView.setTopTracksController(topItemsController);
        return this;
    }

    /**
     * Adds the Recommend Use Case to the application.
     * @return this builder
     */
    public AppBuilder addRecommendUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject,spotifyDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        recommendationsView.setLoginController(loginController);

        final RecommendOutputBoundary recommendOutputBoundary =
                new RecommendPresenter(viewManagerModel, recommendViewModel);
        final RecommendInputBoundary recommendInputBoundary =
                new RecommendInteractor(recommendUserDataAccessObject, recommendOutputBoundary);

        final RecommendController recommendController = new RecommendController(recommendInputBoundary);
        loggedInView.setRecommendController(recommendController);
        return this;
    }

    public AppBuilder addSimilarListenersUseCase() {
        final LoginOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel,
                loggedInViewModel, loginViewModel);
        final LoginInputBoundary loginInteractor = new LoginInteractor(
                userDataAccessObject,spotifyDataAccessObject, loginOutputBoundary);

        final LoginController loginController = new LoginController(loginInteractor);
        similarListenersView.setLoginController(loginController);

        final SimilarListenersOutputBoundary similarListenersOutputBoundary =
                new SimilarListenersPresenter(similarListenersViewModel, viewManagerModel);
        final SimilarListenersInputBoundary similarListenersInputBoundary =
                new SimilarListenersInteractor(spotifyDataAccessObject, similarListenersOutputBoundary);
        final SimilarListenersController similarListenersController =
                new SimilarListenersController(similarListenersInputBoundary);
        loggedInView.setSimilarListenersController(similarListenersController);
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

        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        return application;
    }
}
