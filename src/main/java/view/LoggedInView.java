package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import interface_adapter.keyword.KeywordController;
import interface_adapter.keyword.KeywordPresenter;
import interface_adapter.keyword.KeywordViewModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.recommend.RecommendController;
import interface_adapter.search.SearchController;

import interface_adapter.top_items.TopItemsController;
import data_access.SpotifyService;
import use_case.keyword.KeywordInteractor;


/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private LogoutController logoutController;
    private SearchController searchController;
    private TopItemsController topItemsController;
    private RecommendController recommendController;

    private final JLabel username;
    private final JButton logOut;
    private final JPanel searchButtons = new JPanel();
    private final JPanel appButtons = new JPanel();

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Home Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JPanel profile = new JPanel(new FlowLayout(FlowLayout.LEFT));
        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();
        logOut = new JButton("Log Out");
        profile.add(usernameInfo);
        profile.add(username);
        profile.add(logOut);

        final JButton description = new JButton("Search song by description");
        searchButtons.add(description);
        final JButton keyword = new JButton("Search song by keyword");
        searchButtons.add(keyword);
        // Add ActionListener for the "Search song by keyword" button
        keyword.addActionListener(evt -> {
            if (evt.getSource().equals(keyword)) {
                // Retrieve the current frame
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

                // Retrieve the access token
                String accessToken = "BQCBkcgNkBgo48s7ZJlGRO2ohyiOJHc1nlBD-E6-6EsRsOILmexOHd3G81Bj3wKAymo8i1qOg8tvHPUSQASHL67WGTw4E_KlyXkpRyfMGIF67EOVLtY"; // Assuming the token is stored as the username

                // Ensure the token exists
                if (accessToken == null || accessToken.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Access token is missing. Please log in again.");
                    return;
                }

                // Initialize components for the Keyword feature
                KeywordViewModel viewModel = new KeywordViewModel();
                KeywordPresenter presenter = new KeywordPresenter(viewModel);
                SpotifyService spotifyService = new SpotifyService(accessToken);
                KeywordInteractor interactor = new KeywordInteractor(spotifyService, presenter);
                KeywordController keywordController = new KeywordController(interactor, viewModel);

                // Create the Keyword view and set it as the content pane
                KeywordView keywordPage = new KeywordView(keywordController, viewModel);
                frame.setContentPane(keywordPage.getPanel(frame));
                frame.revalidate(); // Refresh the frame to display the new content
            }
        });
        final JButton home = new JButton("Home");
        appButtons.add(home);
        final JButton recommendations = new JButton("Recommendations");
        appButtons.add(recommendations);
        final JButton topItems = new JButton("Top Items");
        appButtons.add(topItems);
        final JButton similarListeners = new JButton("Similar listeners");
        appButtons.add(similarListeners);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        logOut.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        // 1. get the state out of the loggedInViewModel. It contains the username.
                        final String name = loggedInViewModel.getState().getUsername();
                        // 2. Execute the logout Controller.
                        logoutController.execute(name);
                    }
                }
        );

        description.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(description)) {
                        // 1. get the state out of the loggedInViewModel. It contains the username.
                        final String accessToken = loggedInViewModel.getState().getUsername();
                        // 2. Execute the logout Controller.
                        searchController.execute(accessToken);
                    }
                }
        );

        recommendations.addActionListener(
                evt -> {
                    if (evt.getSource().equals(recommendations)) {
                        // final String name = topTracksController
                        final List<String> songRecommendations = new ArrayList<>();
                        final String artistRecommendations = "";
                        final String accessToken = loggedInViewModel.getState().getUsername();
                        recommendController.execute(songRecommendations, artistRecommendations, accessToken);
                    }
                }
        );

        topItems.addActionListener(
                evt -> {

                    if (evt.getSource().equals(topItems)) {
                        final List<String> topTracks = new ArrayList<>();
                        final List<String> topArtists = new ArrayList<>();
                        final String accessToken = loggedInViewModel.getState().getUsername();

                        topItemsController.execute(topTracks, topArtists, accessToken);
                    }
                }
        );

        // Add an ActionListener to open the Keyword window
        keyword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Initialize the required components
                KeywordViewModel viewModel = new KeywordViewModel(); // Create a new ViewModel
                KeywordPresenter presenter = new KeywordPresenter(viewModel); // Create a presenter
                SpotifyService spotifyService = new SpotifyService("ACCESS_TOKEN_HERE"); // Replace with your access token
                KeywordInteractor interactor = new KeywordInteractor(spotifyService, presenter); // Initialize interactor
                KeywordController controller = new KeywordController(interactor, viewModel); // Initialize controller

                // Create and show the KeywordView with required dependencies
                KeywordView keywordWindow = new KeywordView(controller, viewModel);

                keywordWindow.show();
            }
        });

        // Add components to the panel
        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(profile);
        this.add(searchButtons);
        this.add(appButtons);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
        }

    }

    public String getViewName() {
        return viewName;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public void setTopTracksController(TopItemsController topItemsController) {
        this.topItemsController = topItemsController;
    }

    public void setRecommendController(RecommendController recommendController) {
        this.recommendController = recommendController;
    }
}
