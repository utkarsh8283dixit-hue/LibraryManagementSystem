package com.library;

public abstract class Person {

    protected int id;
    protected String name;

    // Constructor
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Abstract method
    public abstract void displayInfo();

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
