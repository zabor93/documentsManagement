package com.Gemalto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.FxmlUtils;

public class Main extends Application {

    public static final String BORDER_PANE_MAIN_FXML = "/FXML/BorderPaneMain.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primarystage) throws Exception {
//        Locale.setDefault(new Locale("en"));
        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
        Scene scene = new Scene(borderPane);
        primarystage.setScene(scene);
//        primarystage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        primarystage.show();
        primarystage.setTitle("ffsd");
    }
}
