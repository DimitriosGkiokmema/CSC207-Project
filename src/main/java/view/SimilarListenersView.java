package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.similar_listeners.SimilarListenersViewModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class SimilarListenersView extends JPanel {
    private final String viewName = "similar listeners";
    private final SimilarListenersViewModel similarListenersViewModel;
    private final JButton back;

    public <T> SimilarListenersView(SimilarListenersViewModel similarListenersViewModel) {
        this.similarListenersViewModel = similarListenersViewModel;
        // this.similarListenersViewModel.addPropertyChangeListener(this);

        // building the interface
        final JLabel title = new JLabel("Similar Listeners");
        final JPanel list = new JPanel();

        back = new JButton("Back");
        back.addActionListener(
                new ActionListener() {
                    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
                    private final LoginViewModel loginViewModel = new LoginViewModel();

                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(back)) {
                            viewManagerModel.setState(loginViewModel.getViewName());
                            viewManagerModel.firePropertyChanged();

                        }
                    }
                }
        );

        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(list);
        this.add(back);

    }

    public String getViewName() {
        return this.viewName;
    }
}
