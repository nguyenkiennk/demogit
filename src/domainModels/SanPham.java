/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

/**
 *
 * @author hangnt
 */
public class SanPham {

    private String id;
    private String danhMucID;
    private String tenSanPham;
    private int soLuong;
    private double giaNhap;
    private double giaBan;
    private String mieuTa;

    public SanPham() {
    }

    public SanPham(String id, String danhMucID, String tenSanPham, int soLuong, double giaNhap, double giaBan, String mieuTa) {
        this.id = id;
        this.danhMucID = danhMucID;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.mieuTa = mieuTa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDanhMucID() {
        return danhMucID;
    }

    public void setDanhMucID(String danhMucID) {
        this.danhMucID = danhMucID;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(double giaNhap) {
        this.giaNhap = giaNhap;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getMieuTa() {
        return mieuTa;
    }

    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }

}
