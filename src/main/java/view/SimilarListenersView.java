package view;

import javax.swing.*;

public class SimilarListenersView extends JPanel {
    private final SimilarListenersViewModel similarListenersViewModel;

    public SimilarListenersView(SimilarListenersViewModel similarListenersViewModel) {
        this.similarListenersViewModel = similarListenersViewModel;
        final JLabel title = new JLabel("Similar Listeners");
        final JPanel list = new JPanel();
        list.setLayout(new BoxLayout(list, BoxLayout.Y_AXIS));
        this.add(title);

    }
}
