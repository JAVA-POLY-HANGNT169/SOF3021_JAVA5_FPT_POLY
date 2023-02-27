package com.poly.hangnt169.service.impl;

import com.poly.hangnt169.repository.ChuyenNganhRepository;
import com.poly.hangnt169.response.ChuyenNganhResponse;
import com.poly.hangnt169.service.ChuyenNganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hangnt169
 */
@Service
public class ChuyenNganhServiceImpl implements ChuyenNganhService {

    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;

    @Override
    public List<ChuyenNganhResponse> hienThiDanhSachChuyenNganh() {
        return chuyenNganhRepository.getAllChuyenNganh();
    }

}
