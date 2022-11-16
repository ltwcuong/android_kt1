package com.example.myapplication;

public class Thongtin {

        private String ten;
        private String capbac;
        private String noicongtac;
        private String soSao;
        private int hinh;

    public Thongtin(String ten, String capbac, String noicongtac, String soSao, int hinh) {
        this.ten = ten;
        this.capbac = capbac;
        this.noicongtac = noicongtac;
        this.soSao = soSao;
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getCapbac() {
        return capbac;
    }

    public void setCapbac(String capbac) {
        this.capbac = capbac;
    }

    public String getNoicongtac() {
        return noicongtac;
    }

    public void setNoicongtac(String noicongtac) {
        this.noicongtac = noicongtac;
    }

    public String getSoSao() {
        return soSao;
    }

    public void setSoSao(String soSao) {
        this.soSao = soSao;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
