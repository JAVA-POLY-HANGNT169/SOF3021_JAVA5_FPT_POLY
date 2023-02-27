package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.Lop;
import com.poly.hangnt169.response.LopResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hangnt169
 */
@Repository
public interface LopHocRepository extends JpaRepository<Lop, Long> {

    @Query("SELECT new com.poly.hangnt169.response.LopResponse(cn.id,cn.maLop,cn.tenLop,cn.soLuongSV) FROM Lop cn")
    List<LopResponse> getAllLopHoc();

    @Query("SELECT new com.poly.hangnt169.response.LopResponse(cn.id,cn.maLop,cn.tenLop,cn.soLuongSV) FROM Lop cn WHERE cn.id =?1")
    LopResponse detailLopHoc(Long id);

}
