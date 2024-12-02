package app;

import javax.swing.*;
//import java.Constants;
import java.awt.*;

/**
 * The Main class of our application.
 */
public class Main {
    /**
     * Builds and runs the CA architecture of the application.
     * @param args unused arguments
     */
    public static void main(String[] args) {

        final AppBuilder appBuilder = new AppBuilder();
        final JFrame application = appBuilder
                .addLoginView()
                .addRecommendationsView()
                .addSearchView()
                .addTopItemsView()
                .addKeywordView()
                .addLoggedInView()
                .addSimilarListenersView()
                .addLoginUseCase()
                .addLogoutUseCase()
                .addRecommendUseCase()
                .addSearchUseCase()
                .addTopItemsUseCase()
                .addSimilarListenersUseCase()
                .addKeywordUseCase()
                .build();

        application.pack();
        application.setVisible(true);
    }
}
