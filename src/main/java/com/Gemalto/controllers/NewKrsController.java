package com.Gemalto.controllers;

import com.Gemalto.modelsFX.ProjectFx;
import com.Gemalto.modelsFX.ProjectModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class NewKrsController {

    @FXML
    private TextField customerTextField;

    @FXML
    private TextField stgTextField;

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
        projectModel.saveProjectInDataBase(customerTextField.getText(), krsTextField.getText(), stgTextField.getText(), dpPaTextField.getText());
        customerTextField.clear();
        stgTextField.clear();
        dpPaTextField.clear();
        krsTextField.clear();
    }

    public void editProjectActionButton(ActionEvent actionEvent) {
    }

    public void selectionItemProjects(ActionEvent actionEvent) {
    }
}
