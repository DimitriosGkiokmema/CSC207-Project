package view;

import java.util.List;

import interface_adapter.ViewManagerModel;
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
    private final JTextArea listOfArtists;

    public <T> SimilarListenersView(SimilarListenersViewModel similarListenersViewModel) {
        this.similarListenersViewModel = similarListenersViewModel;
        this.similarListenersViewModel.addPropertyChangeListener(this);

        // building the interface
        //final JLabel title = new JLabel("Your Similar Listeners: ");
        //title.setAlignmentX(Component.CENTER_ALIGNMENT);

        final JLabel title = new JLabel("Your Similar Listeners: ");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        listOfArtists = new JTextArea("list of names appear here");
        listOfArtists.setEditable(true);
        final JPanel similarListenersInfo = new JPanel();
        similarListenersInfo.add(title);
        similarListenersInfo.add(listOfArtists);
        similarListenersInfo.setLayout(new BoxLayout(similarListenersInfo, BoxLayout.Y_AXIS));

        back = new JButton("Go Back");
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
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
        //this.add(title);
        this.add(similarListenersInfo);
        this.add(back);

    }

    public String getViewName() {
        return viewName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SimilarListenersState similarListenersState = (SimilarListenersState) evt.getNewValue();
        setListOfArtists(similarListenersState);

    }

    public void setListOfArtists(SimilarListenersState similarListenersState) {
        String artistsNames = "";
        List<String> followedArtists = similarListenersState.getSimilarArtists();
        for (String followedArtist : followedArtists) {
            artistsNames += followedArtist + "\n";
        }
        listOfArtists.setText(artistsNames);

    }

}
