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

//    @Column(name = "krs")
//    private Integer krs;
//
//    @Column(name = "stg")
//    private Integer stg;
//
//    @Column(name = "dp_PA")
//    private Integer dpPa;

//    @OneToOne
//    @JoinColumn(name = "id_details")
//    private ProjectDetails projectDetails;

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

//    public Integer getKrs() {
//        return krs;
//    }
//
//    public void setKrs(Integer krs) {
//        this.krs = krs;
//    }
//
//    public Integer getStg() {
//        return stg;
//    }
//
//    public void setStg(Integer stg) {
//        this.stg = stg;
//    }
//
//    public Integer getDpPa() {
//        return dpPa;
//    }
//
//    public void setDpPa(Integer dpPa) {
//        this.dpPa = dpPa;
//    }

//    public Project(String client, Integer krs, Integer stg, Integer dpPa) {
//        this.client = client;
////        this.krs = krs;
////        this.stg = stg;
////        this.dpPa = dpPa;
//    }

    public Project(String client) {
        this.client = client;
    }

    public Project() {
    }
//
//    @Override
//    public String toString() {
//        return "Project{" +
//                "client='" + client + '\'' +
//                ", krs=" + krs +
//                ", stg=" + stg +
//                ", dpPa=" + dpPa +
//                '}';
//    }
}

