package com.example.thecoffeehouse.model_adapter;

import android.widget.ImageView;

import java.io.Serializable;

public class DoUong {
    private int id;
    private String loaisp;
    private String hinh;
    private String ten;
    private String gia;

    public DoUong(int id, String loaisp, String ten, String gia, String hinh) {
        this.id = id;
        this.loaisp = loaisp;
        this.ten = ten;
        this.gia = gia;
        this.hinh = hinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
