package com.Gemalto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import utils.FxmlUtils;

import java.io.IOException;

public class MainController {
    @FXML
    private TopMenuButtonController topMenuButtonsController;

    @FXML
    private ToolController toolController;

    @FXML
    private BorderPane borderPane;

    @FXML
    private void initialize() {
        topMenuButtonsController.setMainController(this);
    }

    public void setCenter(String fxmlPath) {
        borderPane.setCenter(FxmlUtils.fxmlLoader(fxmlPath));
    }

    @FXML
    public void closeApplication(ActionEvent event) {
    }

    @FXML
    public void setCaspian(ActionEvent event) {
    }

    @FXML
    public void setAlwaysOnTop(ActionEvent event) {
    }

    @FXML
    public void setModena(ActionEvent event) {
    }
}
