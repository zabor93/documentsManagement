package com.Gemalto.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LinkController {

    @FXML
    private Button oeSecurityButton;

    @FXML
    private Button siteMappingItalyButton;


    public void oeSecurityActionButton(javafx.event.ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop browser= Desktop.getDesktop();
        browser.browse(new URI("https://confluence.gemalto.com/display/TCDSecurity/OE+Security"));

    }

    public void siteMappingItalyActionButton(ActionEvent actionEvent) throws URISyntaxException, IOException {
        Desktop browser= Desktop.getDesktop();
        browser.browse(new URI("http://www.google.com"));
    }
}
