package uz.shox.intentjava.model;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: "+id + "\nName: "+name;
    }
}
