package com.Gemalto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.FxmlUtils;

import java.io.IOException;

public class LoginController {

    public void loginActionButton(ActionEvent event) throws IOException {

        Parent tableView= FXMLLoader.load(getClass().getResource("/FXML/BorderPaneMain.fxml"));
        Scene tableViewScene = new Scene(tableView);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(tableViewScene);
        window.show();
    }
}
