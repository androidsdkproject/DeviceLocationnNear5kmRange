package com.example.android1.devicelocation;

import android.graphics.Bitmap;

/**
 * Created by Android1 on 7/26/2017.
 */

public class ListDeviceModel {
    String deviceid, device_name;
    String location;
    double devicelat, devicelong, devicedistance;
    Bitmap deviceimage;


    ListDeviceModel(String deviceid, String device_name, double devicelat, double devicelong, double devicedistance, Bitmap deviceimage, String location) {

        this.deviceid = deviceid;
        this.device_name = device_name;
        this.devicelat = devicelat;
        this.devicelong = devicelong;
        this.devicedistance = devicedistance;
        this.deviceimage = deviceimage;
        this.location = location;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public double getDevicelat() {
        return devicelat;
    }

    public void setDevicelat(double devicelat) {
        this.devicelat = devicelat;
    }

    public double getDevicelong() {
        return devicelong;
    }

    public void setDevicelong(double devicelong) {
        this.devicelong = devicelong;
    }

    public double getDevicedistance() {
        return devicedistance;
    }

    public void setDevicedistance(double devicedistance) {
        this.devicedistance = devicedistance;
    }

    public Bitmap getDeviceimage() {
        return deviceimage;
    }

    public void setDeviceimage(Bitmap deviceimage) {
        this.deviceimage = deviceimage;
    }
}
