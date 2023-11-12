/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

/**
 *
 * @author hangnt
 */
public class HoaDonChiTietResponse {

    private String id;
    private String hoaDonID;
    private String sanPhamID;
    private String tenSanPham;
    private int soLuong;
    private double donGia;

    public HoaDonChiTietResponse() {
    }

    public HoaDonChiTietResponse(String id, String hoaDonID, String sanPhamID,
            String tenSanPham, int soLuong, double donGia) {
        this.id = id;
        this.hoaDonID = hoaDonID;
        this.sanPhamID = sanPhamID;
        this.tenSanPham = tenSanPham;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getSanPhamID() {
        return sanPhamID;
    }

    public void setSanPhamID(String sanPhamID) {
        this.sanPhamID = sanPhamID;
    }

    public String getHoaDonID() {
        return hoaDonID;
    }

    public void setHoaDonID(String hoaDonID) {
        this.hoaDonID = hoaDonID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double thanhTien() {
        return soLuong * donGia;
    }

    public Object[] toDataRow() {
        return new Object[]{tenSanPham, soLuong, donGia, thanhTien()};
    }

}
