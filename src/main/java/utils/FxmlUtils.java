package utils;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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


    public void changeScreen(ActionEvent event,String path) throws IOException {

        Parent tableView= FXMLLoader.load(getClass().getResource(path));
        Scene tableViewScene = new Scene(tableView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
}
