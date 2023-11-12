/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories.impl;

import domainModels.HoaDon;
import responsitories.HoaDonResponsitory;
import utilities.DBConnection;
import viewmodels.HoaDonResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class HoaDonResponsitoryImpl implements HoaDonResponsitory {

    @Override
    public List<HoaDonResponse> getAll() {
        String query = """
                        SELECT id, ngay_tao, ten_nguoi_nhan, dia_chi, 
                        so_dien_thoai, trang_thai
                        FROM WS_FA22_BL1.dbo.hoa_don
                        ORDER BY ngay_tao DESC;
                       """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonResponse> listHoaDons = new ArrayList<>();
            while (rs.next()) {
                HoaDonResponse hoaDonResponse = new HoaDonResponse(rs.getString(1),
                        rs.getDate(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6));
                listHoaDons.add(hoaDonResponse);
            }
            return listHoaDons;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public HoaDon getOne(String id) {
        String query = """
                        SELECT id, ngay_tao, ten_nguoi_nhan, dia_chi, 
                        so_dien_thoai, trang_thai
                        FROM WS_FA22_BL1.dbo.hoa_don;
                        WHERE id = ?
                       """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                HoaDon hoaDon = new HoaDon(rs.getString(1), rs.getDate(2),
                        rs.getString(3), rs.getString(4), rs.getString(5),
                        rs.getInt(6));
                return hoaDon;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addHoaDon(HoaDon hoaDon) {
        int check = 0;
        String query = """
                       INSERT INTO WS_FA22_BL1.dbo.hoa_don
                       (ngay_tao,ten_nguoi_nhan, dia_chi, so_dien_thoai, trang_thai)
                       VALUES(?,?,?,?,?);
                       """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, new Date());
            ps.setObject(2, hoaDon.getTenNguoiNhan());
            ps.setObject(3, hoaDon.getDiaChi());
            ps.setObject(4, hoaDon.getSoDienThoai());
            ps.setObject(5, 0);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    @Override
    public boolean updateHoaDon(String id, HoaDon hoaDon) {
        int check = 0;
        String query = """
                       UPDATE WS_FA22_BL1.dbo.hoa_don
                       SET ten_nguoi_nhan= ?, dia_chi= ?, so_dien_thoai=?,
                       trang_thai= 1
                       WHERE id= ?;
                       """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getTenNguoiNhan());
            ps.setObject(2, hoaDon.getDiaChi());
            ps.setObject(3, hoaDon.getSoDienThoai());
            ps.setObject(4, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
