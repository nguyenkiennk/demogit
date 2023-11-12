/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainModels.HoaDon;
import responsitories.HoaDonResponsitory;
import responsitories.impl.HoaDonResponsitoryImpl;
import services.HoaDonService;
import viewmodels.HoaDonResponse;
import java.util.List;

/**
 *
 * @author hangnt
 */
public class HoaDonServiceImpl implements HoaDonService {

    private final HoaDonResponsitory hoaDonResponsitory
            = new HoaDonResponsitoryImpl();

    @Override
    public List<HoaDonResponse> getAll() {
        return hoaDonResponsitory.getAll();
    }

    @Override
    public HoaDon getOne(String id) {
        return hoaDonResponsitory.getOne(id);
    }

    @Override
    public String addHoaDon(HoaDon hoaDon) {
        boolean add = hoaDonResponsitory.addHoaDon(hoaDon);
        if (add) {
            return "Add thanh cong";
        }
        return "Add that bai";
    }

    @Override
    public String updateHoaDon(String id, HoaDon hoaDon) {
        boolean update = hoaDonResponsitory.updateHoaDon(id, hoaDon);
        if (update) {
            return "Update thanh cong";
        }
        return "Update that bai";
    }

}
