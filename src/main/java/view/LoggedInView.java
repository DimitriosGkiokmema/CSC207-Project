package view;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.keyword.KeywordController;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.recommend.RecommendController;
import interface_adapter.search.SearchController;

import interface_adapter.similar_listeners.SimilarListenersController;
import interface_adapter.top_items.TopItemsController;


/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private static final String VIEWNAME = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private LogoutController logoutController;
    private SearchController searchController;
    private TopItemsController topItemsController;
    private RecommendController recommendController;
    private SimilarListenersController similarListenersController;
    private KeywordController keywordController;

    private final JButton logOut;
    private final JPanel searchButtons = new JPanel();
    private final JPanel appButtons = new JPanel();

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Home Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        final JPanel profile = new JPanel();
        profile.setLayout(new BoxLayout(profile, BoxLayout.Y_AXIS));
        //final JLabel usernameInfo = new JLabel("Currently logged in: " + accessToken);
        logOut = new JButton("Log Out");
        //profile.add(usernameInfo);
        profile.add(logOut);

        final JButton description = new JButton("Search song by description");
        searchButtons.add(description);
        final JButton keyword = new JButton("Search song by keyword");
        searchButtons.add(keyword);
        final JButton recommendations = new JButton("Recommendations");
        appButtons.add(recommendations);
        final JButton topItems = new JButton("Top Items");
        appButtons.add(topItems);
        final JButton similarListeners = new JButton("Similar listeners");
        appButtons.add(similarListeners);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        // Add ActionListener for the "Search song by keyword" button
        /*
        keyword.addActionListener(evt -> {
            if (evt.getSource().equals(keyword)) {
                // Retrieve the current frame
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);

                // Retrieve the access token
                String accessToken = "BQB3C0RPRK-jw-xptb5X9nQ_A1yPkwIQBTtdhPbYa5oza3jmru20-sSaMGtPIBT7zcwHblQuYBTnh5Z_pgXC0RGrA5TagXUALHCr8hyXzc3Mxp0cgvI"; // Assuming the token is stored as the username

                // Ensure the token exists
                if (accessToken == null || accessToken.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Access token is missing. Please log in again.");
                    return;
                }

                // Initialize components for the Keyword feature
                KeywordViewModel viewModel = new KeywordViewModel();
                KeywordPresenter presenter = new KeywordPresenter(viewModel);
                SpotifyService spotifyService = new SpotifyService(accessToken);
                KeywordInteractor interactor = new KeywordInteractor(spotifyData, presenter);
                KeywordController keywordController = new KeywordController(interactor, viewModel);

                // Create the Keyword view and set it as the content pane
                KeywordView keywordPage = new KeywordView(keywordController, viewModel);
                frame.setContentPane(keywordPage.getPanel(frame));
                frame.revalidate(); // Refresh the frame to display the new content
            }
        });*/

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        logOut.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        // 1. get the state out of the loggedInViewModel. It contains the username.
                        final String name ="placeholder";
                        // 2. Execute the logout Controller.
                        logoutController.execute(name);
                    }
                }
        );

        description.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(description)) {
                        searchController.execute();
                    }
                }
        );

        recommendations.addActionListener(
                evt -> {
                    if (evt.getSource().equals(recommendations)) {
                        recommendController.execute();
                    }
                }
        );

        topItems.addActionListener(
                evt -> {

                    if (evt.getSource().equals(topItems)) {
                        topItemsController.execute();
                    }
                }
        );

        keyword.addActionListener(
                evt -> {
                    if (evt.getSource().equals(keyword)) {
                        keywordController.execute();

                    }
                }
        );

        similarListeners.addActionListener(
                evt -> {
                    if (evt.getSource().equals(similarListeners)) {
                        similarListenersController.execute();

                    }
                }
        );
        // Add components to the panel
        this.add(title);
        //this.add(usernameInfo);
        this.add(profile);
        this.add(searchButtons);
        this.add(appButtons);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for user");
        }
    }

    public String getViewName() {
        return VIEWNAME;
    }

    public void setKeywordController(KeywordController keywordController) {
        this.keywordController = keywordController;
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
    public void setSimilarListenersController(SimilarListenersController similarListenersController) {
        this.similarListenersController = similarListenersController;
    }

    public void setRecommendController(RecommendController recommendController) {
        this.recommendController = recommendController;
    }
}
