package com.poly.hangnt169.service.impl;

import com.poly.hangnt169.entity.ChuyenNganh;
import com.poly.hangnt169.entity.Lop;
import com.poly.hangnt169.entity.SinhVien;
import com.poly.hangnt169.repository.ChuyenNganhRepository;
import com.poly.hangnt169.repository.LopHocRepository;
import com.poly.hangnt169.repository.SinhVienRepository;
import com.poly.hangnt169.request.SinhVienRequest;
import com.poly.hangnt169.response.SinhVienResponse;
import com.poly.hangnt169.service.SinhVienService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;

/**
 * @author hangnt169
 */
@Service
public class SinhVienServiceImpl implements SinhVienService {

    @Autowired
    private SinhVienRepository sinhVienRepository;

    @Autowired
    private LopHocRepository lopHocRepository;

    @Autowired
    private ChuyenNganhRepository chuyenNganhRepository;


    @Override
    public List<SinhVienResponse> hienThiSinhVien() {
        return sinhVienRepository.getAllSinhVien();
    }

    @Override
    public SinhVienResponse detailSinhVien(Long id) {
        return sinhVienRepository.detailSinhVien(id);
    }

    @Override
    public void removeSinhVien(Long id) {
        SinhVien sv = sinhVienRepository.findById(id).get();
        sinhVienRepository.delete(sv);
    }

    @Override
    @Transactional
    @Modifying
    public HashMap<String, String> addOrUpdateSinhVien(SinhVienRequest request) {
        HashMap<String, String> lists = new HashMap<>();
        if (StringUtils.isEmpty(request.getMa())) {
            lists.put("MSSV_EMPTY", "MSSV không được để trống");
        }
        if (StringUtils.isEmpty(request.getTen())) {
            lists.put("TEN_EMPTY", "Tên SV không được để trống");
        }
        if (StringUtils.isEmpty(request.getEmail())) {
            lists.put("EMAIL_EMPTY", "Email không được để trống");
        }

        if (lists.isEmpty()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setId(request.getId());
            sinhVien.setMaSV(request.getMa());
            sinhVien.setTen(request.getTen());
            sinhVien.setGioiTinh(request.isGioiTinh());
            sinhVien.setEmail(request.getEmail());
            Lop lop = lopHocRepository.findById(Long.valueOf(request.getLopID())).get();
            ChuyenNganh chuyenNganh = chuyenNganhRepository.findById(Long.valueOf(request.getChuyenNganhID())).get();
            sinhVien.setLop(lop);
            sinhVien.setChuyenNganh(chuyenNganh);
            sinhVienRepository.save(sinhVien);
        }
        return lists;
    }

}
