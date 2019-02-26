package com.Gemalto.models;

import javax.persistence.*;

@Entity
@Table(name = "Project")
public class Project {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idProject", unique = true, nullable = false)
    private Integer id;

    @Column(name = "client")
    private String client;

    @Column(name = "krs")
    private String krs;

    @Column(name = "stg")
    private String stg;

    @Column(name = "dp_PA")
    private String dpPa;

    @Column
    private String hiperlink;

    @Column
    private String comment;


    public String getHiperlink() {
        return hiperlink;
    }

    public void setHiperlink(String hiperlink) {
        this.hiperlink = hiperlink;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


//    @OneToOne
//    @JoinColumn(name = "id_details")
//    private ProjectDetails projectDetails;


    public Project(String client, String krs, String stg, String dpPa) {
        this.client = client;
        this.krs = krs;
        this.stg = stg;
        this.dpPa = dpPa;
    }

    public Project() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getKrs() {
        return krs;
    }

    public void setKrs(String krs) {
        this.krs = krs;
    }

    public String getStg() {
        return stg;
    }

    public void setStg(String stg) {
        this.stg = stg;
    }

    public String getDpPa() {
        return dpPa;
    }

    public void setDpPa(String dpPa) {
        this.dpPa = dpPa;
    }

    @Override
    public String toString() {
        return "Project{" +
                "client='" + client + '\'' +
                ", krs=" + krs +
                ", stg=" + stg +
                ", dpPa=" + dpPa +
                '}';
    }
}

