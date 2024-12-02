package view;

import interface_adapter.keyword.KeywordController;
import interface_adapter.keyword.KeywordState;
import interface_adapter.keyword.KeywordViewModel;
import interface_adapter.login.LoginController;

import javax.swing.*;
import java.awt.*;
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
    private final JLabel keywordLabel;
    private final JLabel artistLabel;
    private final JPanel panel = new JPanel();

    public KeywordView(KeywordViewModel keywordViewModel) {
        this.keywordViewModel = keywordViewModel;
        this.keywordViewModel.addPropertyChangeListener(this);

        setLayout(new BorderLayout(10, 10)); // Add spacing between sections
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add padding around the panel

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add spacing between components
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Artist Name Label and TextField
        artistLabel = new JLabel("Artist Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(artistLabel, gbc);

        artistField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        inputPanel.add(artistField, gbc);

        // Keyword Label and TextField
        keywordLabel = new JLabel("Keyword:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        inputPanel.add(keywordLabel, gbc);

        keywordField = new JTextField();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        inputPanel.add(keywordField, gbc);

        // Search Button
        searchButton = new JButton("Search");
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 2;
        gbc.fill = GridBagConstraints.BOTH;
        inputPanel.add(searchButton, gbc);

        // Results Panel
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        scrollPane = new JScrollPane(resultsArea);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Results"));

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        homeButton = new JButton("Home");
        buttonPanel.add(homeButton);

        // Add Listeners
        searchButton.addActionListener(evt -> {
            if (evt.getSource().equals(searchButton)) {

                keywordController.executeSearch(artistField.getText(), keywordField.getText());
            }
        });

        homeButton.addActionListener(evt -> {
            if (evt.getSource().equals(homeButton)) {
                loginController.execute();
            }
        });

        // Add Components to Main Panel
        panel.setLayout(new BorderLayout(10, 10));
        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(panel);
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