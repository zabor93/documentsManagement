package com.Gemalto.controllers;

import com.Gemalto.models.Project;
import com.Gemalto.modelsFX.ProjectFx;
import com.Gemalto.modelsFX.ProjectModel;
import com.Gemalto.modelsFX.ToolFx;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
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

    @FXML
    private TableColumn<ProjectFx, String> projectColumnHiperlink;

    @FXML
    private TableColumn<ProjectFx, String> projectColumnComment;

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
        this.projectColumnComment.setCellValueFactory(cellData -> cellData.getValue().commentProperty());

        projectFxTableView.getSelectionModel().setCellSelectionEnabled(true);
        projectFxTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableUtils.installCopyPasteHandler(projectFxTableView);
        addButtonToTable();
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
        browser.browse(new URI("https://www2.pdm.gemalto.com/Windchill/app/#ptc1/homepage"));
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


    private void addButtonToTable() {
        TableColumn<ProjectFx, Void> column = new TableColumn("PDM");

        Callback<TableColumn<ProjectFx, Void>, TableCell<ProjectFx, Void>> cellFactory = new Callback<TableColumn<ProjectFx, Void>, TableCell<ProjectFx, Void>>() {

            @Override
            public TableCell<ProjectFx, Void> call(final TableColumn<ProjectFx, Void> param) {
                final TableCell<ProjectFx, Void> cell = new TableCell<ProjectFx, Void>() {
//                    ProjectFx data = getTableView().getItems().get(getIndex());
                    private final Button btn = new Button("GotoPDM");
                    {
                        btn.setOnAction((ActionEvent event) -> {
                            ProjectFx data = getTableView().getItems().get(getIndex());
//                            DialogUtils.dialogAboutApplication();
//                            showDialog(data.getDescription());
                            Desktop browser= Desktop.getDesktop();
                            try {
                                browser.browse(new URI(data.getHiperlink()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                            System.out.println("selectedData: " + data);
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
//                            setGraphic(btn2);
                        }
                    }
                };
                return cell;
            }
        };

        column.setCellFactory(cellFactory);
        projectFxTableView.getColumns().add(column);

    }

}
