package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.SinhVien;
import com.poly.hangnt169.response.SinhVienResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hangnt169
 */
@Repository
public interface SinhVienRepository extends JpaRepository<SinhVien, Long> {

    @Query("SELECT new com.poly.hangnt169.response.SinhVienResponse(sv.id,sv.maSV,sv.ten,sv.email,sv.gioiTinh," +
            " sv.lop.tenLop,sv.chuyenNganh.tenChuyenNganh,sv.lop.id,sv.chuyenNganh.id) FROM SinhVien sv JOIN Lop l ")
    List<SinhVienResponse> getAllSinhVien();

    @Query("SELECT new com.poly.hangnt169.response.SinhVienResponse(sv.id,sv.maSV,sv.ten,sv.email,sv.gioiTinh," +
            " sv.lop.tenLop,sv.chuyenNganh.tenChuyenNganh,sv.lop.id,sv.chuyenNganh.id) FROM SinhVien sv JOIN Lop l " +
            " WHERE sv.id = ?1")
    SinhVienResponse detailSinhVien(Long id);
}
