package com.example.n.myapplication.models;

import android.os.Parcel;
import android.os.Parcelable;

public class DemoModel implements Parcelable {
    private String cityName;
    private String imgUrl;


    public DemoModel() {
    }

    public DemoModel(String cityName, String imgUrl) {
        this.cityName = cityName;
        this.imgUrl = imgUrl;
    }

    protected DemoModel(Parcel in) {
        cityName = in.readString();
        imgUrl = in.readString();
    }

    public static final Creator<DemoModel> CREATOR = new Creator<DemoModel>() {
        @Override
        public DemoModel createFromParcel(Parcel in) {
            return new DemoModel(in);
        }

        @Override
        public DemoModel[] newArray(int size) {
            return new DemoModel[size];
        }
    };

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(cityName);
        parcel.writeString(imgUrl);
    }
}
