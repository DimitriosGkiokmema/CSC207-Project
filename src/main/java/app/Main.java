package app;

import javax.swing.*;
import java.Constants;
import java.awt.*;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {
        JPanel thus = new JPanel();
        final String viewName = "Search";
        //private final SearchViewModel searchViewModel;
        //private SearchController searchController;

        final int searchBoxSize = 50;

        final JButton returnHome;
        final JTextField searchInputField;
        final JLabel searchResult;
        final JPanel searchButtons = new JPanel();

        //thus.searchViewModel = searchViewModel;
        //thus.searchViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Song Search By Description");

        final JPanel homeButton = new JPanel();
        returnHome = new JButton("Go Back");
        homeButton.add(returnHome);

        searchResult = new JLabel("This is where search results will show up");

        final JLabel description = new JLabel("Type In the Song Description:");
        searchButtons.add(description);
        searchInputField = new JTextField(searchBoxSize);
        searchButtons.add(searchInputField);

        searchResult.setAlignmentX(Component.RIGHT_ALIGNMENT);

        thus.setLayout(new BoxLayout(thus, BoxLayout.Y_AXIS));

        thus.add(title);
        thus.add(searchButtons);
        thus.add(searchResult);
        thus.add(homeButton);
        final JFrame application = new JFrame("CSC207 Project: Spotify Companion App");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.add(thus);
        application.pack();
        application.setVisible(true);
        /*
        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addLoginView()
                .addLoggedInView()
                .addLoginUseCase()

                .addLogoutUseCase()
                .addSearchUseCase()
                .build();

        application.pack();
        application.setVisible(true);

         */
    }
}
