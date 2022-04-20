package uz.shox.intentjava.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Users implements Parcelable {
    private int id;
    private String name;

    public Users(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected Users(Parcel in) {
        id = in.readInt();
        name = in.readString();
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    @Override
    public String toString() {
        return "ID: "+id + "\nName: "+name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
    }
}
