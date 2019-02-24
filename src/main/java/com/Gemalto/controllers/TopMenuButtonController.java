package com.Gemalto.controllers;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.ButtonType;
import utils.DialogUtils;

import java.util.Optional;

public class TopMenuButtonController {

    public static final String KRS_TABLE = "/FXML/KrsTable.fxml";
    public static final String LINK_TABLE = "/FXML/LinkTable.fxml";
    public static final String KRS_ADDING_TABLE = "/FXML/NewKrs.fxml";


    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void krsActionButton(ActionEvent event) {
        mainController.setCenter(KRS_TABLE);

    }
    public void toolsActionButton(ActionEvent event) {
        System.out.println("HEJJJ");
    }

    public void linkActionButton(ActionEvent event) {
        mainController.setCenter(LINK_TABLE);
    }

    public void addActionButton(ActionEvent actionEvent) {
        mainController.setCenter(KRS_ADDING_TABLE);
    }

    public void closeActionButton(ActionEvent event) {
        Optional<ButtonType> result = DialogUtils.dialogConfirmationExit();
        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }

    public void caspianActionButton(ActionEvent event) {
        Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
    }

    public void modenaActionButton(ActionEvent event) {
        Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
    }

    public void aboutActionButton(ActionEvent event) {
        DialogUtils.dialogAboutApplication();
    }
}
