package uz.shox.intentjava.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Members implements Parcelable {
    private String name;
    private String lastname;

    public Members(String name, String lastname) {
        this.name = name;
        this.lastname = lastname;
    }

    protected Members(Parcel in) {
        name = in.readString();
        lastname = in.readString();
    }

    public static final Creator<Members> CREATOR = new Creator<Members>() {
        @Override
        public Members createFromParcel(Parcel in) {
            return new Members(in);
        }

        @Override
        public Members[] newArray(int size) {
            return new Members[size];
        }
    };

    @Override
    public String toString() {
        return "Name: "+name+"\nLastname: "+lastname;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(lastname);
    }
}
