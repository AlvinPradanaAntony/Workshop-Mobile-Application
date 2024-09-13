package com.example.appwithfragments;

import android.os.Parcel;
import android.os.Parcelable;

public class dataFIlm implements Parcelable {
   private String judul, releaseDate, DiskripsiFilm;
   private int categoryID;

    public dataFIlm(String judul, String releaseDate, String diskripsiFilm, int categoryID) {
        this.judul = judul;
        this.releaseDate = releaseDate;
        this.DiskripsiFilm = diskripsiFilm;
        this.categoryID = categoryID;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getCategoryID() {return categoryID;}

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDiskripsiFilm() {
        return DiskripsiFilm;
    }

    public void setDiskripsiFilm(String diskripsiFilm) {
        DiskripsiFilm = diskripsiFilm;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.releaseDate);
        dest.writeString(this.DiskripsiFilm);
    }

    public void readFromParcel(Parcel source) {
        this.judul = source.readString();
        this.releaseDate = source.readString();
        this.DiskripsiFilm = source.readString();
    }

    protected dataFIlm(Parcel in) {
        this.judul = in.readString();
        this.releaseDate = in.readString();
        this.DiskripsiFilm = in.readString();
    }

    public static final Creator<dataFIlm> CREATOR = new Creator<dataFIlm>() {
        @Override
        public dataFIlm createFromParcel(Parcel source) {
            return new dataFIlm(source);
        }

        @Override
        public dataFIlm[] newArray(int size) {
            return new dataFIlm[size];
        }
    };
}
