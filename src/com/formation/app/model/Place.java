package com.formation.app.model;

public class Place {
    private Long Id;
    private String name;

    public Place(Long id, String name) {
        this.Id = id;
        this.name = name;
    }

    public Place(String name) {
        this.name = name;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
