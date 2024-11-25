package view;

import interface_adapter.keyword.KeywordController;
import interface_adapter.keyword.KeywordViewModel;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;

public class KeywordView {
    private final KeywordController controller;
    private final KeywordViewModel viewModel;

    public KeywordView(KeywordController controller, KeywordViewModel viewModel) {
        this.controller = controller;
        this.viewModel = viewModel;
    }

    public JPanel getPanel(JFrame frame) {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel artistLabel = new JLabel("Artist Name:");
        artistLabel.setBounds(50, 30, 100, 30);
        panel.add(artistLabel);

        JTextField artistField = new JTextField();
        artistField.setBounds(150, 30, 400, 30);
        panel.add(artistField);

        JLabel keywordLabel = new JLabel("Keyword:");
        keywordLabel.setBounds(50, 80, 100, 30);
        panel.add(keywordLabel);

        JTextField keywordField = new JTextField();
        keywordField.setBounds(150, 80, 400, 30);
        panel.add(keywordField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(580, 30, 100, 80);
        panel.add(searchButton);

        JTextArea resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        scrollPane.setBounds(50, 140, 650, 200); // Adjust size as needed
        panel.add(scrollPane);

        // Add ActionListener for the "Search" button
        searchButton.addActionListener(e -> {
            String artistName = artistField.getText();
            String keyword = keywordField.getText();

            // Trigger search and update viewModel
            viewModel.setLoading(true);
            controller.searchByKeyword(artistName, keyword);

            // Check results and update the UI accordingly
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
        });

        JButton homeButton = new JButton("Return Home");
        homeButton.setBounds(580, 350, 150, 30); // Positioned at the bottom-right corner
        panel.add(homeButton);

        homeButton.addActionListener(e -> {
            LoggedInView loggedInPage = new LoggedInView(new LoggedInViewModel());
            frame.setContentPane(loggedInPage);
            frame.revalidate();
        });

        return panel;
    }

    public void show() {
    }
}