/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitories.impl;

import responsitories.HoaDonChiTietResponsitory;
import utilities.DBConnection;
import viewmodels.HoaDonChiTietResponse;
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
public class HoaDonChiTietResponsitoryImpl implements HoaDonChiTietResponsitory {

    @Override
    public List<HoaDonChiTietResponse> getAllByHoaDonID(String id) {
        String query = """
                         SELECT
                        	hdct .id,
                        	hd.id ,
                        	sp.id ,
                        	sp.ten_san_pham ,
                        	hdct .so_luong ,
                        	hdct .don_gia
                        FROM hoa_don_chi_tiet hdct
                        INNER JOIN san_pham sp 
                        ON sp.id = hdct .san_pham_id
                        INNER JOIN hoa_don hd 
                        ON hd.id = hdct.hoa_don_id 
                        WHERE hdct .hoa_don_id  = ?
                       """;
        try (Connection con = DBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<HoaDonChiTietResponse> listHoaDonChiTiets = new ArrayList<>();
            while (rs.next()) {
                HoaDonChiTietResponse hoaDonChiTietResponse
                        = new HoaDonChiTietResponse(rs.getString(1),
                                rs.getString(2), rs.getString(3),
                                rs.getString(4), rs.getInt(5), rs.getDouble(6));
                listHoaDonChiTiets.add(hoaDonChiTietResponse);
            }
            return listHoaDonChiTiets;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    @Override
    public boolean addListOrder(String hoaDonID, List<HoaDonChiTietResponse> lists) {
        String query = """
                       INSERT INTO WS_FA22_BL1.dbo.hoa_don_chi_tiet
                       (hoa_don_id, san_pham_id, so_luong, don_gia)
                       VALUES(?,?,?,?);
                       """;

        int[] arr = {};
        try (Connection con = DBConnection.getConnection(); // mở kết nối đến DB
                PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                for (HoaDonChiTietResponse hoaDonChiTiet : lists) {
                    ps.setObject(1, hoaDonChiTiet.getHoaDonID());
                    ps.setObject(2, hoaDonChiTiet.getSanPhamID());
                    ps.setObject(3, hoaDonChiTiet.getSoLuong());
                    ps.setObject(4, hoaDonChiTiet.getDonGia());
                    //batch update
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }

}
