package com.Gemalto.controllers;

import com.Gemalto.models.Project;
import com.Gemalto.modelsFX.ProjectFx;
import com.Gemalto.modelsFX.ProjectModel;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import utils.TableUtils;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.function.Predicate;

public class KrsController {

    private ProjectModel projectModel;

    @FXML
    private TextField filterTextField;

    @FXML
    private TableView<ProjectFx> projectFxTableView;

    @FXML
    private TableColumn<ProjectFx, String> projectColumnClient;
    @FXML
    private TableColumn<ProjectFx, String> projectColumnKrs;

    @FXML
    private TableColumn<ProjectFx, String> projectColumnStg;

    @FXML
    private TableColumn<ProjectFx, String> projectColumnDpPa;

//    FilteredList filter = new FilteredList(this.projectModel.getProjectslist(), e -> true);
//    FilteredList<ProjectFx> filteredList = new FilteredList(projectModel.getProjectslist(), e -> true);



    public void initialize() {
        projectModel = new ProjectModel();
        projectModel.init();
        this.projectFxTableView.setItems(this.projectModel.getProjectslist());
        this.projectColumnClient.setCellValueFactory(cellData->cellData.getValue().clientProperty());
        this.projectColumnKrs.setCellValueFactory(cellData -> cellData.getValue().krsProperty());
        this.projectColumnStg.setCellValueFactory(cellData -> cellData.getValue().stgProperty());
        this.projectColumnDpPa.setCellValueFactory(cellData -> cellData.getValue().dpPaProperty());
        projectFxTableView.getSelectionModel().setCellSelectionEnabled(true);
        projectFxTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableUtils.installCopyPasteHandler(projectFxTableView);
        FilteredList<ProjectFx> filteredData = new FilteredList<>(projectModel.getProjectslist(), p -> true);


        // 2. Set the filter Predicate whenever the filter changes.
        filterTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(projectFx -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (projectFx.clientProperty().getValue().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<ProjectFx> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(projectFxTableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        projectFxTableView.setItems(sortedData);
    }


    public void pdmActionButton(ActionEvent event) throws URISyntaxException, IOException {
        Desktop browser= Desktop.getDesktop();
        browser.browse(new URI("http://www.google.com"));
    }

    @FXML
    public void search(KeyEvent keyEvent) {

//        filterTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
//
//            filteredList.setPredicate((Predicate<? super ProjectFx>) (ProjectFx project)->{
//
//                if (newValue.isEmpty() || newValue == null) {
//                    return true;
//                } else if (project.getClient().contains(newValue)) {
//                    return true;
//                }
//            return false;
//            });
//        }));
//        SortedList sort = new SortedList(filteredList);
//        sort.comparatorProperty().bind(projectFxTableView.comparatorProperty());
//        projectFxTableView.setItems(sort);
    }
}
