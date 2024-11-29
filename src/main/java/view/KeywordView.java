package view;

import interface_adapter.keyword.KeywordController;
import interface_adapter.keyword.KeywordState;
import interface_adapter.keyword.KeywordViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.search.SearchState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class KeywordView extends JPanel implements PropertyChangeListener {
    private final KeywordViewModel keywordViewModel;
    private final String viewName = "keyword";
    private KeywordController keywordController;
    private LoginController loginController;

    private final JButton homeButton;
    private final JScrollPane scrollPane;
    private final JTextArea resultsArea;
    private final JButton searchButton;
    private final JTextField artistField;
    private final JTextField keywordField;
    private final  JLabel keywordLabel;
    private final JLabel artistLabel;
    private final JPanel panel = new JPanel();

    public KeywordView( KeywordViewModel keywordViewModel) {
        this.keywordViewModel = keywordViewModel;
        this.keywordViewModel.addPropertyChangeListener(this);

        artistLabel = new JLabel("Artist Name:");
        artistLabel.setBounds(50, 30, 100, 30);
        panel.add(artistLabel);

        artistField = new JTextField();
        artistField.setBounds(150, 30, 400, 30);
        panel.add(artistField);

        keywordLabel = new JLabel("Keyword:");
        keywordLabel.setBounds(50, 80, 100, 30);
        panel.add(keywordLabel);

        keywordField = new JTextField();
        keywordField.setBounds(150, 80, 400, 30);
        panel.add(keywordField);

        searchButton = new JButton("Search");
        searchButton.setBounds(580, 30, 100, 80);
        panel.add(searchButton);

        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        scrollPane = new JScrollPane(resultsArea);
        scrollPane.setBounds(50, 140, 650, 200); // Adjust size as needed
        panel.add(scrollPane);

        // Add ActionListener for the "Search" button
        searchButton.addActionListener(e -> {
            String artistName = artistField.getText();
            String keyword = keywordField.getText();

            // Trigger search and update viewModel
            // controller.searchByKeyword(artistName, keyword);

            // Check results and update the UI accordingly
            /* should all be stored in a prepareFailView
            if (viewModel.isProper_input()) {
                resultsArea.setText("Artist and keyword can not be empty");
            } else if (viewModel.hasError()) {
                resultsArea.setText("Error: " + viewModel.getErrorMessage());
            } else if (viewModel.getSongs() == null && viewModel.getSongs().isEmpty()) {
                // No results found
                resultsArea.setText("Sorry, no songs found matching the keyword \"" + keyword + "\" for artist \"" + artistName + "\".");
            } else if (viewModel.getSongs() != null) {
                // Display the list of songs
                resultsArea.setText(String.join("\n", viewModel.getSongs()));
            }

             */
            resultsArea.setText(keywordViewModel.getState().getDisplayText());
        });
        homeButton = new JButton("Home Button");
        homeButton.setBounds(580, 350, 150, 30); // Positioned at the bottom-right corner
        homeButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(homeButton)) {
                        // 1. get the state out of the searchViewModel. It contains the username.
                        final String accessToken = keywordViewModel.getState().getAccessToken();
                        // 2. Execute the search Controller.
                        loginController.execute(accessToken);

                    }
                }
        );
        panel.add(homeButton);
        searchButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(searchButton)) {
                        // 1. get the state out of the searchViewModel. It contains the username.
                        final String accessToken = keywordViewModel.getState().getAccessToken();
                        // 2. Execute the search Controller.
                        keywordController.executeSearch(accessToken, artistField.getText(),keywordField.getText());

                    }
                }
        );
        this.add(panel);
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
        final KeywordState state = (KeywordState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(KeywordState state) {
        resultsArea.setText(state.getDisplayText());

    }

    public String getViewName() {
        return viewName;
    }

    public void setKeywordController(KeywordController keywordController) {
        this.keywordController = keywordController;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

}