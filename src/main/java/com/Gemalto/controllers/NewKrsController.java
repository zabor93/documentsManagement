package com.Gemalto.controllers;

import com.Gemalto.modelsFX.ProjectFx;
import com.Gemalto.modelsFX.ProjectModel;
import com.Gemalto.modelsFX.ToolFx;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.io.IOException;

public class NewKrsController {

    @FXML
    private TextField customerTextField;

    @FXML
    private TextField stgTextField;

    @FXML
    private TextField pdmTextField;

    @FXML
    private TextField commentTextField;

    @FXML
    private TextField dpPaTextField;

    @FXML
    private TextField krsTextField;

    @FXML
    private Button addProjectButton;

    @FXML
    private Button editProjectButton;

    @FXML
    private ComboBox<ProjectFx> projectComboBox;

    private ProjectModel projectModel;

    @FXML
    public void initialize() {
        this.projectModel = new ProjectModel();
        this.projectModel.init();
        this.projectComboBox.setItems(this.projectModel.getProjectslist());
        initBindings();
    }

    private void initBindings() {
        addProjectButton.disableProperty().bind(customerTextField.textProperty().isEmpty());
        addProjectButton.disableProperty().bind(krsTextField.textProperty().isEmpty());
        addProjectButton.disableProperty().bind(stgTextField.textProperty().isEmpty());
        addProjectButton.disableProperty().bind(dpPaTextField.textProperty().isEmpty());
        stgTextField.disableProperty().bind(customerTextField.textProperty().isEmpty());
        krsTextField.disableProperty().bind(customerTextField.textProperty().isEmpty());
        dpPaTextField.disableProperty().bind(customerTextField.textProperty().isEmpty());
//        removeCategoryButton.disableProperty().bind(this.categoryModel.categoryProperty().isNull());
//        editCategoryButton.disableProperty().bind(this.categoryModel.categoryProperty().isNull());
    }


    public void addProjectActionButton(ActionEvent actionEvent) {
        projectModel.saveProjectInDataBase(customerTextField.getText(), krsTextField.getText(), stgTextField.getText(), dpPaTextField.getText(), pdmTextField.getText(), commentTextField.getText());
        customerTextField.clear();
        stgTextField.clear();
        dpPaTextField.clear();
        krsTextField.clear();
        pdmTextField.clear();
        commentTextField.clear();
    }

    public void editProjectActionButton(ActionEvent actionEvent) {
        System.out.println(this.projectComboBox.getSelectionModel().getSelectedItem().getId());
    }

    public void selectionItemProjects(ActionEvent actionEvent) {
    }




}
