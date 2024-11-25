package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import interface_adapter.login.LoginController;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;

/**
 * The View for when the user is logging into the program.
 */
public class LoginView extends JPanel implements ActionListener, PropertyChangeListener {

    private final String viewName = "log in";
    private final LoginViewModel loginViewModel;

    private final JTextField loginTokenInputField = new JTextField(15);
    private final JLabel accessTokenErrorField = new JLabel();

    private ImageIcon spotifyIcon = new ImageIcon("images/spotify2.png");

    private final JButton logIn;
    private LoginController loginController;

    public LoginView(LoginViewModel loginViewModel) {

        this.loginViewModel = loginViewModel;
        this.loginViewModel.addPropertyChangeListener(this);

        final LabelTextPanel AccessTokenInfo = new LabelTextPanel(
                new JLabel("Access Token"), loginTokenInputField);

        final JPanel buttons = new JPanel();
        logIn = new JButton("log in");
        buttons.add(logIn);

        final Image spotifyImage = spotifyIcon.getImage();
        final Image finalImage = spotifyImage.getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
        spotifyIcon = new ImageIcon(finalImage);
        final JLabel spotifylabel = new JLabel(spotifyIcon);
        spotifylabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        logIn.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(logIn)) {
                            final LoginState currentState = loginViewModel.getState();

                            loginController.execute(
                                    currentState.getLoginToken()
                            );
                        }
                    }
                }
        );

        loginTokenInputField.getDocument().addDocumentListener(new DocumentListener() {

            private void documentListenerHelper() {
                final LoginState currentState = loginViewModel.getState();
                currentState.setLoginToken(loginTokenInputField.getText());
                loginViewModel.setState(currentState);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                documentListenerHelper();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                documentListenerHelper();
            }
        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(spotifylabel);
        this.add(AccessTokenInfo);
        this.add(accessTokenErrorField);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     * @param evt the ActionEvent to react to
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final LoginState state = (LoginState) evt.getNewValue();
        setFields(state);
        accessTokenErrorField.setText(state.getLoginError());
    }

    private void setFields(LoginState state) {
        loginTokenInputField.setText(state.getLoginToken());

    }

    public String getViewName() {
        return viewName;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
}
