package com.poly.hangnt169.service.impl;

import com.poly.hangnt169.entity.Lop;
import com.poly.hangnt169.repository.LopHocRepository;
import com.poly.hangnt169.request.LopHocRequest;
import com.poly.hangnt169.response.LopResponse;
import com.poly.hangnt169.service.LopService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hangnt169
 */
@Service
public class LopServiceImpl implements LopService {

    @Autowired
    private LopHocRepository lopHocRepository;

    @Override
    public List<LopResponse> hienThiDanhSachLop() {
        return lopHocRepository.getAllLopHoc();
    }

    @Override
    public LopResponse detailLopHoc(Long id) {
        return lopHocRepository.detailLopHoc(id);
    }

    @Override
    public void removeLopHoc(Long id) {
        Lop lopHoc = lopHocRepository.findById(id).get();
        lopHocRepository.delete(lopHoc);
    }

    @Transactional
    @Modifying
    @Override
    public void addOrUpdateLopHoc(@Valid LopHocRequest request) {
        Lop sinhVien = new Lop();
        sinhVien.setId(request.getId());
        sinhVien.setTenLop(request.getTenLop());
        sinhVien.setMaLop(request.getMaLop());
        sinhVien.setSoLuongSV(request.getSoLuongSV());
        lopHocRepository.save(sinhVien);
    }

}
