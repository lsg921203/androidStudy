package com.example.androidstudy.model;

import java.io.Serializable;

public class Member implements Serializable {
    private String name;
    private String tel;
    private Integer imgRes;
    private int PhoneType;//핸드폰, 집전화, 회사전화

    public Member() {}

    public Member(String name, String tel, Integer imgRes, int phoneType) {
        this.name = name;
        this.tel = tel;
        this.imgRes = imgRes;
        PhoneType = phoneType;
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

    public Integer getImgRes() {
        return imgRes;
    }

    public void setImgRes(Integer imgRes) {
        this.imgRes = imgRes;
    }

    public int getPhoneType() {
        return PhoneType;
    }

    public void setPhoneType(int phoneType) {
        PhoneType = phoneType;
    }

    @Override
    public String toString() {
        return "name=" + name + '\n' +
                "tel=" + tel ;
    }
}
