package view;

import interface_adapter.keyword.KeywordController;
import interface_adapter.keyword.KeywordViewModel;
import interface_adapter.logged_in.LoggedInViewModel;

import javax.swing.*;
import java.awt.*;

public class Keyword {
    private final KeywordController controller;
    private final KeywordViewModel viewModel;

    public Keyword(KeywordController controller, KeywordViewModel viewModel) {
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

        // Create a scrollable JTextArea
        JTextArea resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);
        scrollPane.setBounds(50, 140, 650, 300); // Adjust size as needed
        panel.add(scrollPane);

        // Add action listener to search button
        searchButton.addActionListener(e -> {
            String artistName = artistField.getText();
            String keyword = keywordField.getText();

            viewModel.setLoading(true);
            controller.searchByKeyword(artistName, keyword);

            if (viewModel.isLoading()) {
                resultsArea.setText("Loading...");
            } else if (viewModel.hasError()) {
                resultsArea.setText("Error: " + viewModel.getErrorMessage());
            } else if (viewModel.getSongs() != null) {
                // Display all songs in the JTextArea
                resultsArea.setText(String.join("\n", viewModel.getSongs()));
            }
        });

        // Add "Return Home" button
        JButton homeButton = new JButton("Return Home");
        homeButton.setBounds(580, 450, 150, 30); // Adjust positioning
        panel.add(homeButton);

        homeButton.addActionListener(e -> {
            LoggedInView loggedInPage = new LoggedInView(new LoggedInViewModel());
            frame.setContentPane(loggedInPage);
            frame.revalidate();
        });

        return panel;
    }
}