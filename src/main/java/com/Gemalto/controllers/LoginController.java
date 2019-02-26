package com.Gemalto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.FxmlUtils;

import javax.swing.tree.ExpandVetoException;
import java.io.IOException;

public class LoginController {

    private static final String LOGINPATH = "/FXML/BorderPaneMain.fxml";

    public void loginActionButton(ActionEvent event) throws IOException {

        FxmlUtils FXML=new FxmlUtils();
        FXML.changeScreen(event,LOGINPATH);
//        FxmlUtils.changeScreen(event, LOGINPATH);
    }
}
