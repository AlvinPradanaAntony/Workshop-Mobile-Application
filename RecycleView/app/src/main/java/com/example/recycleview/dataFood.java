package com.example.recycleview;

import android.os.Parcel;
import android.os.Parcelable;

public class dataFood implements Parcelable {
    private String nama, level, deskripsi;
    private double rating;

    public dataFood(String nama, String level, String deskripsi, double rating) {
        this.nama = nama;
        this.level = level;
        this.deskripsi = deskripsi;
        this.rating = rating;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.level);
        dest.writeString(this.deskripsi);
        dest.writeDouble(this.rating);
    }

    public void readFromParcel(Parcel source) {
        this.nama = source.readString();
        this.level = source.readString();
        this.deskripsi = source.readString();
        this.rating = source.readDouble();
    }

    protected dataFood(Parcel in) {
        this.nama = in.readString();
        this.level = in.readString();
        this.deskripsi = in.readString();
        this.rating = in.readDouble();
    }

    public static final Creator<dataFood> CREATOR = new Creator<dataFood>() {
        @Override
        public dataFood createFromParcel(Parcel source) {
            return new dataFood(source);
        }

        @Override
        public dataFood[] newArray(int size) {
            return new dataFood[size];
        }
    };
}
