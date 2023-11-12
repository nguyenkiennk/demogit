/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import responsitories.HoaDonChiTietResponsitory;
import responsitories.impl.HoaDonChiTietResponsitoryImpl;
import services.HoaDonChiTietService;
import viewmodels.HoaDonChiTietResponse;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class HoaDonChiTietServiceImpl implements HoaDonChiTietService {

    private final HoaDonChiTietResponsitory hoaDonChiTietResponsitory
            = new HoaDonChiTietResponsitoryImpl();

    @Override
    public List<HoaDonChiTietResponse> getAllByHoaDonID(String id) {
        return hoaDonChiTietResponsitory.getAllByHoaDonID(id);
    }

    @Override
    public String addListOrder(String hoaDonID, List<HoaDonChiTietResponse> lists) {
        boolean add = hoaDonChiTietResponsitory.addListOrder(hoaDonID, lists);
        if (add) {
            return "Add thanh cong";
        }
        return "Add that bai";
    }

}
