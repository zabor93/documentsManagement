package com.Gemalto.controllers;

import com.Gemalto.modelsFX.ToolFx;
import com.Gemalto.modelsFX.ToolModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import utils.DialogUtils;
import utils.FxmlUtils;
import utils.TableUtils;

import java.io.IOException;

public class ToolController {

    @FXML
    private TableView<ToolFx> tableView;

    @FXML
    private TextField toolTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private TableColumn<ToolFx, String> toolColumnName;
    //    @FXML
//    private TableColumn<ToolFx, String> toolColumnDescription;
    @FXML
//    private TableColumn<ToolFx, Button> toolColumnButton;

    private ToolModel toolModel;

    public static final String TOOL_TABLE = "/FXML/ToolTable.fxml";


    @FXML
    public void initialize() {
        this.toolModel = new ToolModel();
        this.toolModel.init();
        this.tableView.setItems(this.toolModel.getToolList());
        this.toolColumnName.setCellValueFactory(cellData -> cellData.getValue().toolProperty());
//        this.toolColumnDescription.setCellValueFactory(cellData -> cellData.getValue().descriptionProperty());
        tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        TableUtils.installCopyPasteHandler(tableView);
        addButtonToTable();
        addButtonToTable2();

    }

    public void addActionButton(ActionEvent event) {

        toolModel.saveToolInDataBase(toolTextField.getText(), descriptionTextField.getText());
        toolTextField.clear();
        descriptionTextField.clear();
    }

    private void addButtonToTable() {
        TableColumn<ToolFx, Void> colBtn = new TableColumn("DESCRIPTION");

        Callback<TableColumn<ToolFx, Void>, TableCell<ToolFx, Void>> cellFactory = new Callback<TableColumn<ToolFx, Void>, TableCell<ToolFx, Void>>() {
            @Override
            public TableCell<ToolFx, Void> call(final TableColumn<ToolFx, Void> param) {
                final TableCell<ToolFx, Void> cell = new TableCell<ToolFx, Void>() {
                    private final Button btn = new Button("DESCRIPTION");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            ToolFx data = getTableView().getItems().get(getIndex());
//                            DialogUtils.dialogAboutApplication();
//                            showDialog(data.getDescription());
                            try {
//                                loginActionButton(event, "/FXML/tools/" + data.getName() + ".fxml");
                                actionButton("/FXML/tools/" + data.getTool() + ".fxml");
                            } catch (IOException e) {
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
        colBtn.setCellFactory(cellFactory);
        tableView.getColumns().add(colBtn);
    }


    private void addButtonToTable2() {
        TableColumn<ToolFx, Void> colBtn2 = new TableColumn("COMMENTS");

        Callback<TableColumn<ToolFx, Void>, TableCell<ToolFx, Void>> cellFactory = new Callback<TableColumn<ToolFx, Void>, TableCell<ToolFx, Void>>() {
            @Override
            public TableCell<ToolFx, Void> call(final TableColumn<ToolFx, Void> param) {
                final TableCell<ToolFx, Void> cell2 = new TableCell<ToolFx, Void>() {
                    private final Button btn2 = new Button("COMMENTS");

                    {
                        btn2.setOnAction((ActionEvent event) -> {
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
                            setGraphic(btn2);
//                            setGraphic(btn2);
                        }
                    }
                };
                return cell2;
            }
        };

        colBtn2.setCellFactory(cellFactory);
        tableView.getColumns().add(colBtn2);

    }


    public void showDialog(String description) {
//        Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
        Alert i = new Alert(Alert.AlertType.INFORMATION);
        i.setTitle("Information");
        i.setHeaderText("Important comments about tool: ");
        i.setContentText(description);
        i.showAndWait();
    }


    public void loginActionButton(ActionEvent event, String path) throws IOException {
        FxmlUtils fxmlUtils = new FxmlUtils();
        fxmlUtils.changeScreen(event, path);
    }

    public void actionButton(String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("How to instal");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}
