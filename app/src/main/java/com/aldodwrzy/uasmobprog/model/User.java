package com.aldodwrzy.uasmobprog.model;

public class User {
    private String id, name, npm, avatar;

    public User(){

    }

    public User(String name, String npm, String avatar){
        this.name = name;
        this.npm = npm;
        this.avatar = avatar;
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

    public String getNpm() {
        return npm;
    }

    public void setNpm(String npm) {
        this.npm = npm;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
