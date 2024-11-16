package view;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.recommend.RecommendController;
import interface_adapter.recommend.RecommendState;
import interface_adapter.recommend.RecommendViewModel;

/**
 * The View for when the user is logged into the program.
 */
public class RecommendationsView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final RecommendViewModel recommendViewModel;
    private RecommendController recommendController;

    private final JLabel description;
    private final JPanel songsPanel;
    private final JButton homeButton;

    public RecommendationsView(RecommendViewModel recommendViewModel) {
        this.recommendViewModel = recommendViewModel;
        this.recommendViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Recommendations");
        description = new JLabel("Because you've listened to " + getArtist()
                + ", here are some songs you might like:");
        homeButton = new JButton("Home");

        songsPanel = new JPanel();
        final ImageIcon refreshImg = new ImageIcon(getClass().getResource("/images/refresh.png"));
        final JButton refreshButton = new JButton();
        refreshButton.setIcon(refreshImg);
        final JTextArea songsTextArea = new JTextArea(10, 20);
        songsTextArea.setText("TO DO: Get songs to show here");
        final JScrollPane songsScrollPane = new JScrollPane(songsTextArea);
        songsPanel.add(songsScrollPane);
        songsPanel.add(refreshButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

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
        panel.add(title);
        panel.add(description);
        panel.add(songsPanel);
        panel.add(homeButton);

        this.add(panel, BorderLayout.CENTER);
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
