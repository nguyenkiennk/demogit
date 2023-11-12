/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModels;

/**
 *
 * @author hangnt
 */
public class HoaDonChiTiet {

    private String id;
    private String hoaDonID;
    private String sanPhamID;
    private int soLuong;
    private double donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String id, String hoaDonID, String sanPhamID, int soLuong, double donGia) {
        this.id = id;
        this.hoaDonID = hoaDonID;
        this.sanPhamID = sanPhamID;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(String hoaDonID) {
        this.hoaDonID = hoaDonID;
    }

    public String getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(String sanPhamID) {
        this.sanPhamID = sanPhamID;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

}
