import javax.swing.*;
import java.awt.*;

public class SpotifyCompanionUI {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("CSC207 Project: Spotify Companion");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLayout(null); // Absolute layout for positioning

        // Title label
        JLabel titleLabel = new JLabel("CSC207 Project: Spotify Companion", SwingConstants.LEFT);
        titleLabel.setBounds(10, 10, 400, 30);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 14));
        frame.add(titleLabel);

        // Profile icon (placeholder circle)
        JLabel profileIcon = new JLabel("👤", SwingConstants.CENTER);
        profileIcon.setBounds(20, 50, 50, 50);
        frame.add(profileIcon);

        // Input fields and labels
        JLabel artistLabel = new JLabel("Artist Name:");
        artistLabel.setBounds(80, 50, 100, 30);
        frame.add(artistLabel);

        JTextField artistField = new JTextField();
        artistField.setBounds(180, 50, 250, 30);
        frame.add(artistField);

        JLabel lyricsLabel = new JLabel("Lyrics:");
        lyricsLabel.setBounds(80, 90, 100, 30);
        frame.add(lyricsLabel);

        JTextField lyricsField = new JTextField();
        lyricsField.setBounds(180, 90, 250, 30);
        frame.add(lyricsField);

        JLabel keywordLabel = new JLabel("Keyword:");
        keywordLabel.setBounds(80, 130, 100, 30);
        frame.add(keywordLabel);

        JTextField keywordField = new JTextField();
        keywordField.setBounds(180, 130, 250, 30);
        frame.add(keywordField);

        // Search button (magnifying glass icon placeholder)
        JButton searchButton = new JButton("🔍");
        searchButton.setBounds(440, 50, 50, 110);
        frame.add(searchButton);

        // Divider line
        JSeparator separator = new JSeparator();
        separator.setBounds(20, 180, 560, 10);
        frame.add(separator);

        // Songs list area
        JTextArea songsListArea = new JTextArea("Song1\nSong2\n...");
        songsListArea.setBounds(50, 200, 500, 150);
        songsListArea.setEditable(false);
        songsListArea.setBackground(Color.LIGHT_GRAY);
        frame.add(songsListArea);

        // Bottom buttons
        JButton homeButton = new JButton("Home");
        homeButton.setBounds(50, 370, 80, 30);
        homeButton.setBorder(BorderFactory.createDashedBorder(Color.BLACK));
        frame.add(homeButton);

        JButton forYouButton = new JButton("For You");
        forYouButton.setBounds(160, 370, 80, 30);
        frame.add(forYouButton);

        JButton topTracksButton = new JButton("Top Tracks");
        topTracksButton.setBounds(270, 370, 100, 30);
        frame.add(topTracksButton);

        JButton findListenersButton = new JButton("Find Similar Listeners");
        findListenersButton.setBounds(400, 370, 150, 30);
        frame.add(findListenersButton);

        // Set frame visibility
        frame.setVisible(true);
    }
}
