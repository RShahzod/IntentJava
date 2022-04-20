package uz.shox.intentjava.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class MyDatas implements Parcelable {
    private int age;
    private String name;

    public MyDatas(int age, String name) {
        this.age = age;
        this.name = name;
    }

    protected MyDatas(Parcel in) {
        age = in.readInt();
        name = in.readString();
    }

    public static final Creator<MyDatas> CREATOR = new Creator<MyDatas>() {
        @Override
        public MyDatas createFromParcel(Parcel in) {
            return new MyDatas(in);
        }

        @Override
        public MyDatas[] newArray(int size) {
            return new MyDatas[size];
        }
    };

    @Override
    public String toString() {
        return "\nName: " +name + "\nAge: " + age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(age);
        parcel.writeString(name);
    }
}
