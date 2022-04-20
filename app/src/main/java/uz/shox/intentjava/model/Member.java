package uz.shox.intentjava.model;

import android.os.Parcelable;

import java.io.Serializable;

public class Member implements Serializable {
    private String name;
    private String lastname;

    public Member(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Name: "+name+"\nLastname: "+lastname;
    }
}
