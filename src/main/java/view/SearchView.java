package view;

import interface_adapter.change_password.LoggedInState;
import interface_adapter.login.LoginState;
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

    private final int searchBoxSize = 50;

    private final JButton returnHome;
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

        searchResult = new JLabel("This is where search results will show up");

        final JLabel description = new JLabel("Type In the Song Description:");
        searchButtons.add(description);
        searchInputField = new JTextField(searchBoxSize);
        searchButtons.add(searchInputField);

        searchResult.setAlignmentX(Component.RIGHT_ALIGNMENT);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        /* this block of code is to be finished after a discussion about a unified return home use case.
        returnHome.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(returnHome)) {
                        // 1. get the state out of the searchViewModel. It contains the username.
                        final String name = searchViewModel.getState().getUsername();
                        // 2. Execute the search Controller.
                        loginController.execute();
                    }
                }
        );*/

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
        searchInputField.setText(state.getQuery());

    }

    public String getViewName() {
        return viewName;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }
}
