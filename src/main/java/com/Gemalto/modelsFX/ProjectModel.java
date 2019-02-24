package com.Gemalto.modelsFX;

import com.Gemalto.database.dao.GenericDao;
import com.Gemalto.database.dao.GenericDaoImpl;
import com.Gemalto.database.dbUtils.HibernateUtil;
import com.Gemalto.models.Project;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class ProjectModel {

    private ObservableList<ProjectFx> projectslist = FXCollections.observableArrayList();
    private ObjectProperty<ProjectFx> project = new SimpleObjectProperty<>();

    public void init() {
        GenericDao<Project> projectdao = new GenericDaoImpl<>(Project.class, HibernateUtil.getSessionFactory());
        List<Project> projects = projectdao.getAll();
        this.projectslist.clear();
        projects.forEach(c -> {
            ProjectFx projectFx = new ProjectFx();
            projectFx.setId(c.getId());
            projectFx.setClient(c.getClient());
            projectFx.setKrs(c.getKrs());
            projectFx.setStg(c.getStg());
            projectFx.setDpPa(c.getDpPa());
            this.projectslist.add(projectFx);
        });
        HibernateUtil.shutdown();
    }

    public ObservableList<ProjectFx> getProjectslist() {
        return projectslist;
    }

    public void setProjectslist(ObservableList<ProjectFx> projectslist) {
        this.projectslist = projectslist;
    }

    public ProjectFx getProject() {
        return project.get();
    }

    public ObjectProperty<ProjectFx> projectProperty() {
        return project;
    }

    public void setProject(ProjectFx project) {
        this.project.set(project);
    }

    public void deleteProjectById() {
        GenericDao<Project> genericService = new GenericDaoImpl<>(Project.class, HibernateUtil.getSessionFactory());
        genericService.deleteById(Project.class, project.getValue().getId());
        HibernateUtil.shutdown();
        init();
    }


    public void saveProjectInDataBase(String client, String krs, String stg, String dpPa) {
        GenericDao<Project> genericService = new GenericDaoImpl<>(Project.class, HibernateUtil.getSessionFactory());
        Project project = new Project();
        project.setClient(client);
        project.setKrs(krs);
        project.setStg(stg);
        project.setDpPa(dpPa);
        genericService.save(project);
        HibernateUtil.shutdown();
        init();
    }

    public void updateProjectInDataBase() {
        GenericDao<Project> genericService = new GenericDaoImpl<>(Project.class, HibernateUtil.getSessionFactory());
        Project tempProject = (Project) genericService.find(Project.class, getProject().getId());
        tempProject.setClient(getProject().getClient());
        tempProject.setId(getProject().getId());
        tempProject.setStg(getProject().getStg());
        tempProject.setKrs(getProject().getKrs());
        tempProject.setDpPa(getProject().getDpPa());
        genericService.update(tempProject);
        HibernateUtil.shutdown();
        init();
    }
}
