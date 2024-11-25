package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.ViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.similar_listeners.SimilarListenersState;
import interface_adapter.similar_listeners.SimilarListenersViewModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

public class SimilarListenersView extends JPanel implements PropertyChangeListener {
    private final String viewName = "similar listeners";
    private final SimilarListenersViewModel similarListenersViewModel;
    private final JButton back;
    private final JPanel listOfArtists;

    public <T> SimilarListenersView(SimilarListenersViewModel similarListenersViewModel) {
        this.similarListenersViewModel = similarListenersViewModel;
        this.similarListenersViewModel.addPropertyChangeListener(this);

        // building the interface
        final JLabel title = new JLabel("Similar Listeners");
        listOfArtists = new JPanel();

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
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(listOfArtists);
        this.add(title);
        this.add(back);

    }

    public String getViewName() {
        return this.viewName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SimilarListenersState similarListenersState = (SimilarListenersState) evt.getNewValue();

    }
    public void setListOfArtists(SimilarListenersState similarListenersState) {

    }
}
