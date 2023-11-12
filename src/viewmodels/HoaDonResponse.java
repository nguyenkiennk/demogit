/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodels;

import java.util.Date;

/**
 *
 * @author hangnt
 */
public class HoaDonResponse {

    private String id;
    private Date ngayTao;
    private String tenNguoiNhan;
    private String diaChi;
    private String soDienThoai;
    private int trangThai;

    public HoaDonResponse() {
    }

    public HoaDonResponse(String id, Date ngayTao, String tenNguoiNhan,
            String diaChi, String soDienThoai, int trangThai) {
        this.id = id;
        this.ngayTao = ngayTao;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Object[] toDataRow() {
        return new Object[]{ngayTao, trangThai == 0 ? "Chờ thanh toán"
            : trangThai == 1 ? "Đã thanh toán" : ""};
    }
    
}
