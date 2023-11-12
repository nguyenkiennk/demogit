/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import viewmodels.HoaDonChiTietResponse;
import java.util.List;

/**
 *
 * @author hangnt
 */
public interface HoaDonChiTietService {

    List<HoaDonChiTietResponse> getAllByHoaDonID(String id);

    String addListOrder(String hoaDonID, List<HoaDonChiTietResponse> lists);
    
}
