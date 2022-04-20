package uz.shox.intentjava.model;

import java.io.Serializable;

public class MyData implements Serializable {
    private int age;
    private String name;

    public MyData(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nName: " +name + "\nAge: " + age;
    }
}
