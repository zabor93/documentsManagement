package com.Gemalto.controllers.tool;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import utils.FxmlUtils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GpcController {

    @FXML
    private Button openbutton;

    @FXML
    private Button backButton;

        private static final String BACK = "/FXML/BorderPaneMain.fxml";



    public void openActionButton(ActionEvent actionEvent) {

        Desktop d=null;
        File file = new File(System.getenv("programfiles"));
        if(Desktop.isDesktopSupported()){
            d = Desktop.getDesktop();
        }
        try {
            d.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void backActionButton(ActionEvent actionEvent) throws IOException {
        final Node source = (Node) actionEvent.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
