package view;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
        this.recommendViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Recommendations");
        final JPanel titlePanel = new JPanel();
        titlePanel.add(title);

        final JLabel description = new JLabel("Based on your listening history, "
                +"here are some songs you might like:");
        final JPanel descriptionPanel = new JPanel();
        descriptionPanel.add(description);

        homeButton = new JButton("go back");
        final JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.add(homeButton);

        final JPanel songsPanel = new JPanel();
        refreshButton = new JButton("Refresh");
        songsTextArea = new JTextArea();
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
        final RecommendState state = (RecommendState) evt.getNewValue();
        setFields(state);
    }

    private void setFields(RecommendState state) {
        songsTextArea.setText(state.getSongRecommendations());
    }

    public String getViewName() {
        return viewName;
    }

    public void setRecommendController(RecommendController recommendController) {
        this.recommendController = recommendController;
    }

    public String getArtist() {
        return "INSERT ARTIST";
    }
}
