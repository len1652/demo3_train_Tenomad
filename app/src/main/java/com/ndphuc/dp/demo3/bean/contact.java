package com.ndphuc.dp.demo3.bean;

import java.io.Serializable;
import java.util.Date;

public class contact implements Serializable {
    private String id,name,avatar,about,job,address;
    private Date birthDay;

    public contact() {
    }

    public contact(String id, String name, String avatar, String about, String job, String address, Date birthDay) {
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.about = about;
        this.job = job;
        this.address = address;
        this.birthDay = birthDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
