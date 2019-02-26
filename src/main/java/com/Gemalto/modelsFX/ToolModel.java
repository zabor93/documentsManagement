package com.Gemalto.modelsFX;

import com.Gemalto.database.dao.GenericDao;
import com.Gemalto.database.dao.GenericDaoImpl;
import com.Gemalto.database.dbUtils.HibernateUtil;
import com.Gemalto.models.Tool;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

import java.util.List;

public class ToolModel {

    private ObservableList<ToolFx> toolList = FXCollections.observableArrayList();
    private ObjectProperty<ToolFx> tool = new SimpleObjectProperty<>();

    public void init() {
        GenericDao<Tool> toolDao = new GenericDaoImpl<>(Tool.class, HibernateUtil.getSessionFactory());
        List<Tool> tools = toolDao.getAll();
        this.toolList.clear();
        tools.forEach(c -> {
            ToolFx toolFx = new ToolFx();
            toolFx.setId(c.getId());
            toolFx.setTool(c.getTool());
            toolFx.setDescription(c.getDescription());
            toolFx.setButton(new Button("DESCRIPTION"));
            this.toolList.add(toolFx);
        });
        HibernateUtil.shutdown();
    }

    public ObservableList<ToolFx> getToolList() {
        return toolList;
    }

    public void setToolList(ObservableList<ToolFx> toolList) {
        this.toolList = toolList;
    }

    public ToolFx getTool() {
        return tool.get();
    }

    public ObjectProperty<ToolFx> toolProperty() {
        return tool;
    }

    public void setTool(ToolFx tool) {
        this.tool.set(tool);
    }

    public void saveToolInDataBase(String tool, String description) {
        GenericDao<Tool> genericService = new GenericDaoImpl<>(Tool.class, HibernateUtil.getSessionFactory());
        Tool project = new Tool();
        project.setTool(tool);
        project.setDescription(description);
        genericService.save(project);
        HibernateUtil.shutdown();
        init();
    }
}
