package utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class FxmlUtils {
    public static Pane fxmlLoader(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(FxmlUtils.class.getResource(fxmlPath));
//        loader.setResources(getResourceBundle());
        try {
            return loader.load();
        } catch (Exception e) {
//            DialogUtils.errorDialog(e.getMessage());
        }
        return null;
    }
}
