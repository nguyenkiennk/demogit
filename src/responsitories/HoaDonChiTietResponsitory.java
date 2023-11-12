/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package responsitories;

import viewmodels.HoaDonChiTietResponse;
import java.util.List;

/**
 *
 * @author hangnt
 */
public interface HoaDonChiTietResponsitory {

    List<HoaDonChiTietResponse> getAllByHoaDonID(String id);

    boolean addListOrder(String hoaDonID, List<HoaDonChiTietResponse> lists);

}
