package com.crdtech.vistastudents_backend.models;

public class Course {

    // Atributos

    private int id;
    private String name;

    // Métodos construtores

    public Course(int id, String name){

        this.id = id;
        this.name = name;

    }

    public Course(){

    }

    // Métodos


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
