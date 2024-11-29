package app;

import javax.swing.*;
import java.Constants;
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
                .addLoginUseCase()
                .addSearchView()
                .addTopItemsView()
                .addKeywordView()
                .addLoggedInView()
                .addSimilarListenersView()
                .addLogoutUseCase()
                .addSearchUseCase()
                .addTopItemsUseCase()
                .addSimilarListenersUseCase()
                .addKeywordUseCase()
                .build();

        application.pack();
        application.setVisible(true);
    }
}
