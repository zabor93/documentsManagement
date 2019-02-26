package com.Gemalto.models;

import javax.persistence.*;

@Entity
@Table(name = "Tool")
public class Tool {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idTool", unique = true, nullable = false)
    private Integer id;

    @Column(name = "tool")
    private String tool;

    @Column(name = "description")
    private String description;

    public Tool(String tool, String description) {
        this.tool = tool;
        this.description = description;
    }

    public Tool() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTool() {
        return tool;
    }

    public void setTool(String tool) {
        this.tool = tool;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
