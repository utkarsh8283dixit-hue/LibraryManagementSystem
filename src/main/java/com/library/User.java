package com.library;

public class User extends Person {

    private String email;

    // Constructor
    public User(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    // Getter
    public String getEmail() {
        return email;
    }

    // Setter
    public void setEmail(String email) {
        this.email = email;
    }

    // Method overriding
    @Override
    public void displayInfo() {
        System.out.println("User ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}
