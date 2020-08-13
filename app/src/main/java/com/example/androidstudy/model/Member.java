package com.example.androidstudy.model;

public class Member {
    private String name;
    private String tel;
    private String img;
    public Member() {}
    public Member(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return
                "name = " + name + "\n"+
                "tel = " + tel ;
    }
}
