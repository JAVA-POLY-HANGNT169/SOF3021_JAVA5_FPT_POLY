package com.poly.hangnt169.service;

import com.poly.hangnt169.entity.MayTinh;
import org.springframework.data.domain.Page;

public interface MayTinhService {

    Page<MayTinh> getData(int number);

    void add(MayTinh mayTinh);

    void delete(String id);

    void update(String id, MayTinh mayTinh);

    MayTinh findById(String id);

}
