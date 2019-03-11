package com.Gemalto.models;

import javax.persistence.*;

@Entity
@Table(name = "Link")
public class Link {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idLink", unique = true, nullable = false)
    private Integer id;

    @Column(name = "link")
    private String name;

    @Column(name = "comment")
    private String comment;

    @Column(name = "hiperlink")
    private String hiperlink;

    public Link() {
    }

    public Link(String tool, String hiperlink, String comment) {
        this.name = tool;
        this.hiperlink = hiperlink;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getHiperlink() {
        return hiperlink;
    }

    public void setHiperlink(String hiperlink) {
        this.hiperlink = hiperlink;
    }
}
