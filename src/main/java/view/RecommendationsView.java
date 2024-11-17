package view;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.*;

import interface_adapter.recommend.RecommendController;
import interface_adapter.recommend.RecommendState;
import interface_adapter.recommend.RecommendViewModel;

/**
 * The View for when the user is logged into the program.
 */
public class RecommendationsView extends JPanel implements PropertyChangeListener {

    private final String viewName = "recommendations";
    private final RecommendViewModel recommendViewModel;
    private RecommendController recommendController;

    private final JButton refreshButton;
    private final JTextArea songsTextArea;
    private final JButton homeButton;

    public RecommendationsView(RecommendViewModel recommendViewModel) {
        this.recommendViewModel = recommendViewModel;
//        this.recommendViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Recommendations");
        final JPanel titlePanel = new JPanel();
        titlePanel.add(title);

        final JLabel description = new JLabel("Because you've listened to " + getArtist()
                + ", here are some songs you might like:");
        final JPanel descriptionPanel = new JPanel();
        descriptionPanel.add(description);

        homeButton = new JButton("go back");
        final JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.add(homeButton);

        final JPanel songsPanel = new JPanel();
        final ImageIcon refreshImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("images/refresh.png")));
        refreshButton = new JButton("Refresh");
        refreshButton.setIcon(refreshImg);
        songsTextArea = new JTextArea(10, 30);
        songsTextArea.setText("TO DO: Get songs to show here");
        final JScrollPane songsScrollPane = new JScrollPane(songsTextArea);
        songsPanel.add(songsScrollPane);
        songsPanel.add(refreshButton);

//        changePassword.addActionListener(
//                // This creates an anonymous subclass of ActionListener and instantiates it.
//                evt -> {
//                    if (evt.getSource().equals(changePassword)) {
//                        final LoggedInState currentState = loggedInViewModel.getState();
//
//                        this.changePasswordController.execute(
//                                currentState.getUsername(),
//                                currentState.getPassword()
//                        );
//                    }
//                }
//        );
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
        if (evt.getPropertyName().equals("state")) {
            final RecommendState state = (RecommendState) evt.getNewValue();
//            username.setText(state.getUsername());
        }
    }

    public String getViewName() {
        return viewName;
    }

    public void setRecommendController(RecommendController recommendController) {
        this.recommendController = recommendController;
    }

    public String getArtist() {
        return "Slipkot";
    }
}
