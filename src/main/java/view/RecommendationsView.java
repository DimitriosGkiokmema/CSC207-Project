package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import interface_adapter.login.LoginController;
import interface_adapter.recommend.RecommendState;
import interface_adapter.recommend.RecommendViewModel;

/**
 * The View for when the user is logged into the program.
 */
public class RecommendationsView extends JPanel implements PropertyChangeListener {

    private final String viewName = "recommendations";
    private final RecommendViewModel recommendViewModel;
    private LoginController loginController;

    private JLabel topArtists;
    private final JTextArea songsTextArea;
    private final JButton homeButton;

    public RecommendationsView(RecommendViewModel recommendViewModel) {
        this.recommendViewModel = recommendViewModel;
        this.recommendViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Recommendations");
        final JPanel titlePanel = new JPanel();
        titlePanel.add(title);

        final JLabel description = new JLabel("Because you've listened to " + topArtists
                + "here are some songs you might like:");
        final JPanel descriptionPanel = new JPanel();
        descriptionPanel.add(description);

        homeButton = new JButton("go back");
        final JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.add(homeButton);

        final JPanel songsPanel = new JPanel();
        songsTextArea = new JTextArea();
        songsTextArea.setText("Error: songs not displaying");
        final JScrollPane songsScrollPane = new JScrollPane(songsTextArea);
        songsPanel.add(songsScrollPane);

        homeButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(homeButton)) {
                        // 1. Execute the search Controller.
                        loginController.execute();

                    }
                }
        );

        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(titlePanel);
        panel.add(descriptionPanel);
        panel.add(songsPanel);
        panel.add(homeButtonPanel);

        this.add(panel);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final RecommendState state = (RecommendState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(RecommendState state) {
        topArtists = new JLabel();
        String topArtistsText = state.getTopArtists() != null ? state.getTopArtists() : "No top artists available";
        topArtists.setText(topArtistsText);
        songsTextArea.setText(state.getSongRecommendations());
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
