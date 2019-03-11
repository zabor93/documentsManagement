package com.Gemalto.modelsFX;

import com.Gemalto.database.dao.GenericDao;
import com.Gemalto.database.dao.GenericDaoImpl;
import com.Gemalto.database.dbUtils.HibernateUtil;
import com.Gemalto.models.Link;
import com.Gemalto.models.Project;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import org.omg.CORBA.portable.ApplicationException;

import java.util.List;

public class LinkModel {

    private ObservableList<LinkFx> linkList = FXCollections.observableArrayList();
    private ObjectProperty<LinkFx> link = new SimpleObjectProperty<>(new LinkFx());

    public LinkFx getLinkedit() {
        return linkedit.get();
    }

    public ObjectProperty<LinkFx> linkeditProperty() {
        return linkedit;
    }

    public void setLinkedit(LinkFx linkedit) {
        this.linkedit.set(linkedit);
    }

    private ObjectProperty<LinkFx> linkedit = new SimpleObjectProperty<>();

    public void init() {
        GenericDao<Link> genericDao = new GenericDaoImpl<>(Link.class, HibernateUtil.getSessionFactory());
        List<Link> links = genericDao.getAll();
        this.linkList.clear();
        links.forEach(link1 -> {
            LinkFx linkFx = new LinkFx();
            linkFx.setId(link1.getId());
            linkFx.setName(link1.getName());
//            textField.setText(link1.getComment());
            linkFx.setRemarks(link1.getComment());
            linkFx.setHiperlink(link1.getHiperlink());
            linkList.add(linkFx);
        });
        HibernateUtil.shutdown();
    }

    public void saveProjectInDataBase(String name, String hiperlink, String comment) {
        GenericDao<Link> genericService = new GenericDaoImpl<>(Link.class, HibernateUtil.getSessionFactory());
        Link link = new Link();
        link.setName(name);
        link.setHiperlink(hiperlink);
        link.setComment(comment);
        genericService.save(link);
        HibernateUtil.shutdown();
        init();
    }

    public void saveOrUpdate() throws ApplicationException {
        GenericDao<Link> genericService = new GenericDaoImpl<>(Link.class, HibernateUtil.getSessionFactory());
        Link link = genericService.get(Link.class,getLinkedit().getId());
        link.setComment(getLinkedit().getRemarks());
        genericService.update(link);
        HibernateUtil.shutdown();
        this.init();
    }


    public ObservableList<LinkFx> getLinkList() {
        return linkList;
    }

    public void setLinkList(ObservableList<LinkFx> linkList) {
        this.linkList = linkList;
    }

    public LinkFx getLink() {
        return link.get();
    }

    public ObjectProperty<LinkFx> linkProperty() {
        return link;
    }

    public void setLink(LinkFx link) {
        this.link.set(link);
    }
}
