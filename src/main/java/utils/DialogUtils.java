package utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class DialogUtils {

    public static void dialogAboutApplication(){
        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        informationAlert.setTitle("About application");
        informationAlert.setHeaderText("ver. 0.1 Application");
        informationAlert.setContentText("by Kuba");
        informationAlert.showAndWait();
    }

    public static Optional<ButtonType> dialogConfirmationExit(){
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        return result;
    }

    public static void errorDialog(String error) {
        Alert alerterror = new Alert(Alert.AlertType.ERROR);
//        alerterror.setTitle(bundle.getString("error.title"));
//        alerterror.setHeaderText(bundle.getString("error.header"));

        TextArea textArea = new TextArea(error);
        alerterror.getDialogPane().setContent(textArea);
        alerterror.showAndWait();
    }

    public static String editDialog(String value) {
        TextInputDialog textInputDialog = new TextInputDialog(value);
        textInputDialog.setHeaderText("EDIT");
        textInputDialog.setTitle("EDIT");
        textInputDialog.setContentText("Enter new Value");
        Optional<String> result = textInputDialog.showAndWait();
        if (result.isPresent()) {
            return result.get();
        }
        return null;
    }
}