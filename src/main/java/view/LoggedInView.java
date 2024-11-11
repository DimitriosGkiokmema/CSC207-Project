package view;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import interface_adapter.change_password.ChangePasswordController;
import interface_adapter.change_password.LoggedInState;
import interface_adapter.change_password.LoggedInViewModel;
import interface_adapter.logout.LogoutController;

/**
 * The View for when the user is logged into the program.
 */
public class LoggedInView extends JPanel implements PropertyChangeListener {

    private final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;
    private ChangePasswordController changePasswordController;
    private LogoutController logoutController;

    private final JLabel username;
    private final JButton logOut;
    private final JPanel searchButtons = new JPanel();
    private final JPanel appButtons = new JPanel();

    public LoggedInView(LoggedInViewModel loggedInViewModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        final JLabel title = new JLabel("Home Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        final JPanel profile = new JPanel();
        logOut = new JButton("Log Out");
        profile.add(logOut);

        final JButton description = new JButton("Describe a song");
        searchButtons.add(description);
        final JButton lyrics = new JButton("Search song lyrics");
        searchButtons.add(lyrics);

        final JButton home = new JButton("Home");
        appButtons.add(home);
        final JButton recommendations = new JButton("Recommendations");
        appButtons.add(recommendations);
        final JButton topTracks = new JButton("Top Tracks");
        appButtons.add(topTracks);
        final JButton similarListeners = new JButton("Similar listeners");
        appButtons.add(similarListeners);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

//        passwordInputField.getDocument().addDocumentListener(new DocumentListener() {
//
//            private void documentListenerHelper() {
//                final LoggedInState currentState = loggedInViewModel.getState();
//                currentState.setPassword(passwordInputField.getText());
//                loggedInViewModel.setState(currentState);
//            }
//
//            @Override
//            public void insertUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void removeUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//
//            @Override
//            public void changedUpdate(DocumentEvent e) {
//                documentListenerHelper();
//            }
//        });

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

        logOut.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(logOut)) {
                        // 1. get the state out of the loggedInViewModel. It contains the username.
                        final String name = loggedInViewModel.getState().getUsername();
                        // 2. Execute the logout Controller.
                        logoutController.execute(name);
                    }
                }
        );

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(profile);
        this.add(searchButtons);
        this.add(appButtons);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
        }

    }

    public String getViewName() {
        return viewName;
    }

    public void setChangePasswordController(ChangePasswordController changePasswordController) {
        this.changePasswordController = changePasswordController;
    }

    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }
}
