package com.poly.hangnt169.repository;

import com.poly.hangnt169.entity.ChuyenNganh;
import com.poly.hangnt169.response.ChuyenNganhResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hangnt169
 */
@Repository
public interface ChuyenNganhRepository extends JpaRepository<ChuyenNganh, Long> {

    @Query("SELECT new com.poly.hangnt169.response.ChuyenNganhResponse(cn.id,cn.tenChuyenNganh) FROM ChuyenNganh cn")
    List<ChuyenNganhResponse> getAllChuyenNganh();

}
