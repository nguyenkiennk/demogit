/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services.impl;

import domainModels.SanPham;
import responsitories.SanPhamRespository;
import responsitories.impl.SanPhamRespositoryImpl;
import services.SanPhamService;
import viewmodels.SanPhamResponse;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hangnt
 */
public class SanPhamServiceImpl implements SanPhamService {

    private final SanPhamRespository sanPhamRespository
            = new SanPhamRespositoryImpl();

    @Override
    public List<SanPhamResponse> getAll() {
        return sanPhamRespository.getAll();
    }

    @Override
    public SanPham getOne(String id) {
        return sanPhamRespository.getOne(id);
    }

    @Override
    public void update(Map<SanPhamResponse, Integer> sanPhamResponse) {
        sanPhamResponse.forEach(
                (k, v) -> {
                    sanPhamRespository.update(k.getId(), v);
                }
        );
    }
}
