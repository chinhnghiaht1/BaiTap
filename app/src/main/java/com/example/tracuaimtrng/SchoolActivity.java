package com.example.tracuaimtrng;

public class SchoolActivity {
    private int avatar;
    private String name;
    private String diachi;
    private double latitude;
    private double longitude;

    public SchoolActivity(int avatar, String name, String diachi, double latitude, double longitude) {
        this.avatar = avatar;
        this.name = name;
        this.diachi = diachi;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public SchoolActivity() {
    }



    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
}
