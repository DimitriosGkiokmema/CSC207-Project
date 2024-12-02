package view;

import interface_adapter.login.LoginController;
import interface_adapter.search.SearchController;
import interface_adapter.search.SearchState;
import interface_adapter.search.SearchViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for when the user is searching via song description.
 */
public class SearchView extends JPanel implements PropertyChangeListener {

    private final String viewName = "search";
    private final SearchViewModel searchViewModel;
    private SearchController searchController;
    private LoginController loginController;

    private final int searchBoxSize = 50;

    private final JButton returnHome;
    private final JButton searchButton;
    private final JTextField searchInputField;
    private final JLabel searchResult;
    private final JLabel title;
    private final JPanel searchButtons = new JPanel();

    public SearchView(SearchViewModel searchViewModel) {
        this.searchViewModel = searchViewModel;
        this.searchViewModel.addPropertyChangeListener(this);

        title = new JLabel("Song Search By Description");

        final JPanel homeButton = new JPanel();
        returnHome = new JButton("Go Back");
        homeButton.add(returnHome);

        searchResult = new JLabel(searchViewModel.getState().getDisplayText());

        final JLabel description = new JLabel("Type In the Song Description:");
        searchButtons.add(description);
        searchInputField = new JTextField(searchBoxSize);
        searchButton = new JButton("Search");
        searchButtons.add(searchInputField);
        searchButtons.add(searchButton);

        searchResult.setAlignmentX(Component.RIGHT_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        /* this block of code is to be finished after a discussion about a unified return home use case.*/
        returnHome.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(returnHome)) {
                        // 1. Execute the home Controller.
                        loginController.execute();

                    }
                }
        );

        searchButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(searchButton)) {
                        searchController.executeSearch( searchInputField.getText());

                    }
                }
        );

        this.add(title);
        this.add(searchButtons);
        this.add(searchResult);
        this.add(homeButton);

    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SearchState state = (SearchState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(SearchState state) {
        searchResult.setText(state.getDisplayText());

    }

    public String getViewName() {
        return viewName;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
