package com.Gemalto.controllers;


import javafx.event.ActionEvent;

public class TopMenuButtonController {

    public static final String KRS_TABLE = "/FXML/KrsTable.fxml";
    public static final String LINK_TABLE = "/FXML/LinkTable.fxml";


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
}
