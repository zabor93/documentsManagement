package com.Gemalto.controllers;

import com.Gemalto.modelsFX.ToolFx;
import com.Gemalto.modelsFX.ToolModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;
import utils.DialogUtils;
import utils.TableUtils;

public class ToolController {

    @FXML
    private TableView<ToolFx> tableView;

    @FXML
    private TextField toolTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TableColumn<ToolFx, String> toolColumnName;
    @FXML
    private TableColumn<ToolFx, String> toolColumnDescription;
    @FXML
//    private TableColumn<ToolFx, Button> toolColumnButton;

    private ToolModel toolModel;

    @FXML
    public void initialize() {
        this.toolModel = new ToolModel();
        this.toolModel.init();
        this.tableView.setItems(this.toolModel.getToolList());
        this.toolColumnName.setCellValueFactory(cellData -> cellData.getValue().toolProperty());
        this.toolColumnDescription.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableUtils.installCopyPasteHandler(tableView);
        addButtonToTable();
    }

    public void addActionButton(ActionEvent event) {

        toolModel.saveToolInDataBase(toolTextField.getText(), descriptionTextField.getText());
        toolTextField.clear();
        descriptionTextField.clear();
    }

    private void addButtonToTable() {
        TableColumn<ToolFx, Void> colBtn = new TableColumn("Description");

        Callback<TableColumn<ToolFx, Void>, TableCell<ToolFx, Void>> cellFactory = new Callback<TableColumn<ToolFx, Void>, TableCell<ToolFx, Void>>() {
            @Override
            public TableCell<ToolFx, Void> call(final TableColumn<ToolFx, Void> param) {
                final TableCell<ToolFx, Void> cell = new TableCell<ToolFx, Void>() {

                    private final Button btn = new Button("DESCRIPTION");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            ToolFx data = getTableView().getItems().get(getIndex());
//                            DialogUtils.dialogAboutApplication();
                            showDialog(data.getDescription());
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
                        }
                    }
                };
                return cell;
            }
        };

        colBtn.setCellFactory(cellFactory);

        tableView.getColumns().add(colBtn);

    }

    public void showDialog(String description){
//        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        Alert i=new Alert(Alert.AlertType.INFORMATION);
        i.setTitle("Information");
//        informationAlert.setHeaderText("ver. 0.1 Application");
        i.setContentText(description);
        i.showAndWait();
    }



}
