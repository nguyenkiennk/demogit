/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories.impl;

import domainModels.SanPham;
import responsitories.SanPhamRespository;
import utilities.DBConnection;
import viewmodels.SanPhamResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class SanPhamRespositoryImpl implements SanPhamRespository {

    @Override
    public List<SanPhamResponse> getAll() {
        String query = """
                        SELECT id, ten_san_pham, so_luong, gia_nhap, gia_ban, mieu_ta
                        FROM WS_FA22_BL1.dbo.san_pham;
                       """;
        try (Connection con = DBConnection.getConnection();  
                PreparedStatement ps = con.prepareStatement(query);) {
            ResultSet rs = ps.executeQuery();
            List<SanPhamResponse> listSanPhams = new ArrayList<>();
            while (rs.next()) {
                SanPhamResponse sanPhamResponse = new SanPhamResponse(
                        rs.getString(1), rs.getString(2), rs.getInt(3),
                        rs.getDouble(4), rs.getDouble(5), rs.getString(6));
                listSanPhams.add(sanPhamResponse);
            }
            return listSanPhams;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public SanPham getOne(String id) {
        String query = """
                       SELECT id, danh_muc_id, ten_san_pham, so_luong, gia_nhap,
                       gia_ban, mieu_ta
                       FROM WS_FA22_BL1.dbo.san_pham
                       WHERE id = ?
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4), rs.getDouble(5),
                        rs.getDouble(6), rs.getString(7));
                return sanPham;
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean update(String id, int soLuong) {
        int check = 0;
        String query = """
                       UPDATE WS_FA22_BL1.dbo.san_pham
                       SET so_luong= ? 
                       WHERE id= ?
                       """;
        try ( Connection con = DBConnection.getConnection();  PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, soLuong);
            ps.setObject(2, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
