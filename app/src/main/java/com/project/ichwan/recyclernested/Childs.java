package com.project.ichwan.recyclernested;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Childs implements Parcelable {

    private String title;

    public Childs(String title) {
        this.title = title;
    }

    public Childs() {

    }

    protected Childs(Parcel in) {
        title = in.readString();
    }

    public static final Creator<Childs> CREATOR = new Creator<Childs>() {
        @Override
        public Childs createFromParcel(Parcel in) {
            return new Childs(in);
        }

        @Override
        public Childs[] newArray(int size) {
            return new Childs[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
    }
}
