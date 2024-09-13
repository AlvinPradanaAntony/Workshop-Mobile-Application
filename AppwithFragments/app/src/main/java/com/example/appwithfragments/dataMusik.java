package com.example.appwithfragments;

import android.os.Parcel;
import android.os.Parcelable;

public class dataMusik implements Parcelable {
   private String judul, artist, liriklagu;
   private int categoryID;

    public dataMusik(String judul, String artist, String liriklagu , int categoryID) {
        this.judul = judul;
        this.artist = artist;
        this.liriklagu = liriklagu;
        this.categoryID = categoryID;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getArtist() {
        return artist;
    }

    public int getCategoryID() {return categoryID; }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLiriklagu() {
        return liriklagu;
    }

    public void setLiriklagu(String liriklagu) {
        this.liriklagu = liriklagu;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.artist);
        dest.writeString(this.liriklagu);
    }

    public void readFromParcel(Parcel source) {
        this.judul = source.readString();
        this.artist = source.readString();
        this.liriklagu = source.readString();
    }

    protected dataMusik(Parcel in) {
        this.judul = in.readString();
        this.artist = in.readString();
        this.liriklagu = in.readString();
    }

    public static final Creator<dataMusik> CREATOR = new Creator<dataMusik>() {
        @Override
        public dataMusik createFromParcel(Parcel source) {
            return new dataMusik(source);
        }

        @Override
        public dataMusik[] newArray(int size) {
            return new dataMusik[size];
        }
    };
}
