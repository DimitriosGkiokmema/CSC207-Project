package view;

import javax.swing.*;

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
 * The View for when the user is opens TopTracks Menu.
 */
public class TopItemsView extends JPanel implements PropertyChangeListener {
    private final TopItemsViewModel topItemsViewModel;

    private final String viewName = "Top Tracks";
    private final String topTracks = "Top Tracks";

    private final JLabel welcomeLabel;
    private final JButton goBack;

    DefaultPieDataset<String> dataset1 = new DefaultPieDataset<>();
    DefaultCategoryDataset dataset2 = new DefaultCategoryDataset();

    public TopItemsView(TopItemsViewModel topItemsViewModel) {
        this.topItemsViewModel = topItemsViewModel;
        this.topItemsViewModel.addPropertyChangeListener(this);

        welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        goBack = new JButton("go back");
        goBack.setAlignmentX(Component.CENTER_ALIGNMENT);

        dataset1.setValue("Artist 1", 200);
        dataset1.setValue("Artist 2", 150);
        dataset1.setValue("Artist 3", 180);

        dataset2.addValue(300, "Track 1", "1'st");
        dataset2.addValue(250, "Track 2", "2'nd");
        dataset2.addValue(200, "Track 3", "3'rd");
        dataset2.addValue(150, "Track 4", "4'th");
        dataset2.addValue(100, "Track 5", "5'th");

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

        this.add(welcomeLabel);
        this.add(chartLayoutPanel);
        this.add(goBack);

    }

    public String getViewName() {
        return viewName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        /* if (evt.getPropertyName().equals("state")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            username.setText(state.getUsername());
        }
        else if (evt.getPropertyName().equals("password")) {
            final LoggedInState state = (LoggedInState) evt.getNewValue();
            JOptionPane.showMessageDialog(null, "password updated for " + state.getUsername());
        } */
    }
}
