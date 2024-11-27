package view;

import javax.swing.*;

import interface_adapter.login.LoginController;
import interface_adapter.top_items.TopItemsState;
import interface_adapter.top_items.TopItemsViewModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * The View for when the user is opens Top Items Menu.
 */
public class TopItemsView extends JPanel implements PropertyChangeListener {
    private final String viewName = "Top Items";
    private final TopItemsViewModel topItemsViewModel;
    private LoginController loginController;

    private final JLabel welcomeLabel;
    private final JButton homeButton;

    private final DefaultPieDataset<String> dataset1 = new DefaultPieDataset<>();
    private final DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

    public TopItemsView(TopItemsViewModel topItemsViewModel) {
        this.topItemsViewModel = topItemsViewModel;
        this.topItemsViewModel.addPropertyChangeListener(this);

        welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        homeButton = new JButton("go back");
        homeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        /* dataset1.setValue("Artist 1", 200);
        dataset1.setValue("Artist 2", 150);
        dataset1.setValue("Artist 3", 180);

        dataset2.addValue(300, "Track 1", "1'st");
        dataset2.addValue(250, "Track 2", "2'nd");
        dataset2.addValue(200, "Track 3", "3'rd");
        dataset2.addValue(150, "Track 4", "4'th");
        dataset2.addValue(100, "Track 5", "5'th"); */

        final JFreeChart chart = ChartFactory.createPieChart(
                "Top Artists", dataset1, true, true, false);

        final JFreeChart chart2 = ChartFactory.createBarChart(
                "Top Tracks", "Month", "Track Ranks", dataset2);

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(300,300));

        final ChartPanel chartPanel1 = new ChartPanel(chart2);
        chartPanel1.setPreferredSize(new Dimension(300, 300));

        final JPanel chartLayoutPanel = new JPanel(new FlowLayout());
        chartLayoutPanel.add(chartPanel);
        chartLayoutPanel.add(chartPanel1);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        homeButton.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(homeButton)) {
                        final String accessToken = topItemsViewModel.getState().getAccessToken();
                        loginController.execute(accessToken);
                    }
                }
        );

        this.add(welcomeLabel);
        this.add(chartLayoutPanel);
        this.add(homeButton);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final TopItemsState state = (TopItemsState) evt.getNewValue();
        setTrackGraph(state);
        setArtistGraph(state);
    }

    public String getViewName() {
        return viewName;
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }
    /**
     * The method updates the dataset for the Top Tracks Graph.
     * @param state stands for the TopItemsState that is being used.
     */
    public void setTrackGraph(TopItemsState state) {
        int decrease = 300;

        for (int i = 0; i < 4; i++) {
            dataset2.addValue(decrease, state.getTracks().get(i), String.valueOf(i + 1));
            decrease -= 50;
        }
    }

    /**
     * The method updates the dataset for the Top Tracks Graph.
     * @param state stands for the TopItemsState that is being used.
     */
    public void setArtistGraph(TopItemsState state) {
        int decrease = 200;

        for (int i = 0; i < 3; i++) {
            dataset1.setValue(state.getArtists().get(i), decrease);
            decrease -= 50;
        }
    }
}
