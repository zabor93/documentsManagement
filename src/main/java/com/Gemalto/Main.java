package com.Gemalto;

import com.Gemalto.database.dao.GenericDao;
import com.Gemalto.database.dao.GenericDaoImpl;
import com.Gemalto.database.dbUtils.HibernateUtil;
import com.Gemalto.models.Project;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import utils.FxmlUtils;

import java.util.List;

public class Main extends Application {

    public static final String BORDER_PANE_MAIN_FXML = "/FXML/BorderPaneMain.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primarystage) throws Exception {
//        Locale.setDefault(new Locale("en"));
        Pane borderPane = FxmlUtils.fxmlLoader(BORDER_PANE_MAIN_FXML);
        Scene scene = new Scene(borderPane);
        primarystage.setScene(scene);
//        primarystage.setTitle(FxmlUtils.getResourceBundle().getString("title.application"));
        primarystage.show();
        primarystage.setTitle("Documents Management");
        HibernateUtil.initDatabase();

        GenericDao<Project> projectGenericDao = new GenericDaoImpl<Project>(Project.class, HibernateUtil.getSessionFactory());
        Project project=new Project("Santander","12","1233","12313312");
        projectGenericDao.save(project);
        List<Project> projects=projectGenericDao.getAll();
        System.out.println(projects.get(0).getClient());
    }
}
