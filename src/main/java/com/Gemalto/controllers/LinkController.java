package com.Gemalto.controllers;

import com.Gemalto.modelsFX.LinkFx;
import com.Gemalto.modelsFX.LinkModel;
import com.Gemalto.modelsFX.ProjectFx;
import javafx.application.Platform;
import javafx.beans.binding.DoubleBinding;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
import org.omg.CORBA.portable.ApplicationException;
import utils.FxmlUtils;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class LinkController {

    @FXML
    private TableView<LinkFx> linkTableView;

    @FXML
    private TableColumn<LinkFx, String> nameColumn;

    @FXML
    private TableColumn<LinkFx, String> commentColumn;

    private LinkModel linkModel;

    @FXML
    private TextField filterTextField2;


    public void initialize() {
        this.linkModel = new LinkModel();
        linkModel.init();
        this.linkTableView.setItems(this.linkModel.getLinkList());
        this.nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        this.commentColumn.setCellValueFactory(cellData -> cellData.getValue().remarksProperty());
        this.commentColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        this.nameColumn.setSortable(true);
        this.commentColumn.resizableProperty();
//        this.commentColumn.prefWidthProperty().bind();
//        this.nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());

//        linkTableView.setColumnResizePolicy(TableView.UNCONSTRAINED_RESIZE_POLICY);
//        linkTableView.setColumnResizePolicy(param -> true);
//        Platform.runLater(() -> FxmlUtils.customResize(linkTableView));


        //        this.commentColumn.setCellValueFactory(new PropertyValueFactory<LinkFx, String>("remarks"));
//        TableColumn remarksCol = new TableColumn("Comment");
//        linkTableView.getColumns().add(remarksCol);

        addButtonToTable();
//        addTextFieldToTable();
//        linkTableView.getSelectionModel().setCellSelectionEnabled(true);
//        linkTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        this.linkTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.linkModel.setLinkedit(newValue);

        });
        FilteredList<LinkFx> filteredData = new FilteredList<>(linkModel.getLinkList(), p -> true);


        // 2. Set the filter Predicate whenever the filter changes.
        filterTextField2.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(linkFx -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = newValue.toLowerCase();

            if (linkFx.nameProperty().getValue().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            }
            return false; // Does not match.
        }));

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<LinkFx> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(linkTableView.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        linkTableView.setItems(sortedData);

    }

    private void addButtonToTable() {
        TableColumn<LinkFx, Void> column = new TableColumn("PDM");

        Callback<TableColumn<LinkFx, Void>, TableCell<LinkFx, Void>> cellFactory = new Callback<TableColumn<LinkFx, Void>, TableCell<LinkFx, Void>>() {

            @Override
            public TableCell<LinkFx, Void> call(final TableColumn<LinkFx, Void> param) {
                final TableCell<LinkFx, Void> cell = new TableCell<LinkFx, Void>() {
                    //                    ProjectFx data = getTableView().getItems().get(getIndex());
                    private final javafx.scene.control.Button btn = new Button("GotoInternet");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            LinkFx data = getTableView().getItems().get(getIndex());
//                            DialogUtils.dialogAboutApplication();
//                            showDialog(data.getDescription());
                            Desktop browser = Desktop.getDesktop();
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
        linkTableView.getColumns().add(column);

    }


    private void addTextFieldToTable() {
        TableColumn<LinkFx, Void> column = new TableColumn("PDM");

        Callback<TableColumn<LinkFx, Void>, TableCell<LinkFx, Void>> cellFactory = new Callback<TableColumn<LinkFx, Void>, TableCell<LinkFx, Void>>() {

            @Override
            public TableCell<LinkFx, Void> call(final TableColumn<LinkFx, Void> param) {
                final TableCell<LinkFx, Void> cell = new TableCell<LinkFx, Void>() {
                    //                    ProjectFx data = getTableView().getItems().get(getIndex());
                    private final TextField btn = new TextField();
                    LinkFx data = getTableView().getItems().get(getIndex());

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
//                            setText(data.getRemarks());
//                            setGraphic(btn2);
                        }
                    }
                };
                return cell;
            }
        };

        column.setCellFactory(cellFactory);
        linkTableView.getColumns().add(column);
    }


    public void search(KeyEvent keyEvent) {
    }

    public void onEditCommitComment(TableColumn.CellEditEvent<LinkFx, String> linkFxStringCellEditEvent) throws ApplicationException {
       this.linkModel.getLinkedit().setRemarks(linkFxStringCellEditEvent.getNewValue());
        System.out.println(this.linkTableView.getSelectionModel().getSelectedItem().getId());
        System.out.println(linkTableView.getSelectionModel().getSelectedItem().getName());

       this.linkModel.saveOrUpdate();

    }


    public void onEditStartComment(TableColumn.CellEditEvent<LinkFx, String> linkFxStringCellEditEvent) {


    }
}
