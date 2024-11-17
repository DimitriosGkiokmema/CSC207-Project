package view;

import javax.swing.*;
import java.awt.*;

public class Keyword {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CSC207 Project: Spotify Companion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLayout(null);

        JPanel profilePanel = new JPanel();
        profilePanel.setBounds(20, 20, 60, 60);
        JLabel profileIcon = new JLabel(new ImageIcon(new ImageIcon("path/to/profile/icon.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
        profilePanel.add(profileIcon);
        frame.add(profilePanel);

        JLabel artistLabel = new JLabel("Artist Name:");
        artistLabel.setBounds(100, 30, 100, 20);
        frame.add(artistLabel);

        JTextField artistField = new JTextField();
        artistField.setBounds(200, 30, 400, 20);
        frame.add(artistField);

        JLabel keywordLabel = new JLabel("Keyword:");
        keywordLabel.setBounds(100, 70, 100, 20);
        frame.add(keywordLabel);

        JTextField keywordField = new JTextField();
        keywordField.setBounds(200, 70, 400, 20);
        frame.add(keywordField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(620, 30, 100, 40);
        frame.add(searchButton);

        JTextArea resultsArea = new JTextArea("Song1\nSong2\n...");
        resultsArea.setBounds(100, 110, 600, 200);
        resultsArea.setEditable(false);
        frame.add(resultsArea);

        JButton goBackButton = new JButton("Go Back");
        goBackButton.setBounds(350, 370, 100, 40);
        frame.add(goBackButton);

        frame.setVisible(true);
    }
}
