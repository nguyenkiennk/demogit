/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package responsitories;

import domainModels.SanPham;
import viewmodels.SanPhamResponse;
import java.util.List;

/**
 *
 * @author hangnt
 */
public interface SanPhamRespository {

    List<SanPhamResponse> getAll();

    SanPham getOne(String id);

    boolean update(String id,int soLuong);
    
}
