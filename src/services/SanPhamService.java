/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package services;

import domainModels.SanPham;
import viewmodels.SanPhamResponse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hangnt
 */
public interface SanPhamService {

    List<SanPhamResponse> getAll();

    SanPham getOne(String id);

    void update(Map<SanPhamResponse, Integer> sanPhamResponse);

}
