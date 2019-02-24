//package com.Gemalto.models;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Project_Details")
//public class ProjectDetails {
//
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    @Column(name = "idProject_details", unique = true, nullable = false)
//    private Integer id;
//
//    @Column(name = "elec_PA")
//    private String elecPa;
//
//    @Column(name = "e_KRS")
//    private String eKrs;
//
//    @OneToOne(mappedBy = "projectDetails")
//    private Project project;
//
//    public ProjectDetails(String elecPa, String eKrs) {
//        this.elecPa = elecPa;
//        this.eKrs = eKrs;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getElecPa() {
//        return elecPa;
//    }
//
//    public void setElecPa(String elecPa) {
//        this.elecPa = elecPa;
//    }
//
//    public String geteKrs() {
//        return eKrs;
//    }
//
//    public void seteKrs(String eKrs) {
//        this.eKrs = eKrs;
//    }
//}
