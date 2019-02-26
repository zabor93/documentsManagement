package com.Gemalto.modelsFX;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;

public class ToolFx {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty tool = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private Button button;

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getTool() {
        return tool.get();
    }

    public StringProperty toolProperty() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool.set(tool);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public ToolFx(IntegerProperty id, StringProperty tool, StringProperty description, Button button) {
        this.id = id;
        this.tool = tool;
        this.description = description;
        this.button = button;
    }

    public ToolFx() {
    }
}
