package utils;

import com.google.common.util.concurrent.AtomicDouble;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    public static void customResize(TableView<?> view) {

        AtomicDouble width = new AtomicDouble();
        view.getColumns().forEach(col -> {
            width.addAndGet(col.getWidth());
        });
        double tableWidth = view.getWidth();

        if (tableWidth > width.get()) {
            TableColumn<?, ?> col = view.getColumns().get(view.getColumns().size()-1);
            col.setPrefWidth(col.getWidth()+(tableWidth-width.get()));
        }

    }
}
