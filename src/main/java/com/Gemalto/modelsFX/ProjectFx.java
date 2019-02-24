package com.Gemalto.modelsFX;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProjectFx {

    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty client = new SimpleStringProperty();
    private StringProperty krs = new SimpleStringProperty();
    private StringProperty stg = new SimpleStringProperty();
    private StringProperty dpPa = new SimpleStringProperty();

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getClient() {
        return client.get();
    }

    public StringProperty clientProperty() {
        return client;
    }

    public void setClient(String client) {
        this.client.set(client);
    }

    public String getKrs() {
        return krs.get();
    }

    public StringProperty krsProperty() {
        return krs;
    }

    public void setKrs(String krs) {
        this.krs.set(krs);
    }

    public String getStg() {
        return stg.get();
    }

    public StringProperty stgProperty() {
        return stg;
    }

    public void setStg(String stg) {
        this.stg.set(stg);
    }

    public String getDpPa() {
        return dpPa.get();
    }

    public StringProperty dpPaProperty() {
        return dpPa;
    }

    public void setDpPa(String dpPa) {
        this.dpPa.set(dpPa);
    }

    @Override
    public String toString() {
        return id.getValue() + ". "+client.getValue();
    }
}
