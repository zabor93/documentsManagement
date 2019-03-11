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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.hibernate.cache.ReadWriteCache;
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
        this.projectColumnComment.setCellFactory(TextFieldTableCell.forTableColumn());

        this.projectFxTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.projectModel.setProject(newValue);
        });
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

                if (projectFx.clientProperty().getValue().toLowerCase().contains(lowerCaseFilter)||projectFx.krsProperty().getValue().toLowerCase().contains(lowerCaseFilter)||projectFx.stgProperty().getValue().toLowerCase().contains(lowerCaseFilter)) {
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



        projectFxTableView.setRowFactory( tv -> {
//            String name= TableUtils.copySelectionToClipboard(projectFxTableView);
            TableRow<ProjectFx> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                    String rowData = row.getItem().getDpPa();
//                    System.out.println(rowData);
//
//                    System.out.println(projectFxTableView.getSelectionModel().getSelectedCells().toString());

                    TablePosition pos = projectFxTableView.getSelectionModel().getSelectedCells().get(0);
                    int row1 = pos.getRow();

// Item here is the table view type:
                    ProjectFx item = projectFxTableView.getItems().get(row1);

                    TableColumn col = pos.getTableColumn();

// this gives the value in the selected cell:
                    String data = (String) col.getCellObservableValue(item).getValue();

                    System.out.println(data);

//                    ProjectFx projectFx=row.getItem();
//                    System.out.println(projectFx.toString());

                    for (int i = 0; i <projectModel.getProjectslist().size() ; i++) {
                        if (data == projectModel.getProjectslist().get(i).getDpPa()) {
                            Desktop browser= Desktop.getDesktop();
                            try {
                                browser.browse(new URI(projectModel.getProjectslist().get(i).getHiperlink()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (URISyntaxException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
            return row ;
        });

    }


    public void pdmActionButton(ActionEvent event) throws URISyntaxException, IOException {
        String name= TableUtils.copySelectionToClipboard(projectFxTableView);
        for (int i = 0; i <projectModel.getProjectslist().size() ; i++) {
            if (name == projectModel.getProjectslist().get(i).getDpPa()) {
                Desktop browser= Desktop.getDesktop();
                browser.browse(new URI(projectModel.getProjectslist().get(i).getHiperlink()));
            }

        }
        System.out.println(name);

        

    }

    @FXML
    public void search(KeyEvent keyEvent) {
//
//        filterTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
//
//            filteredList.setPredicate((Predicate<? super ProjectFx>) (ProjectFx project)->{

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

    public void onEditCommitEditProject(TableColumn.CellEditEvent<ProjectFx, String> projectFxStringCellEditEvent) {
        this.projectModel.getProject().setComment(projectFxStringCellEditEvent.getNewValue());
        this.projectModel.updateProjectInDataBase();    }
}
