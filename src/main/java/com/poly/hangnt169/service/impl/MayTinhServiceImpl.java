package com.poly.hangnt169.service.impl;

import com.poly.hangnt169.entity.MayTinh;
import com.poly.hangnt169.repository.MayTinhRepository;
import com.poly.hangnt169.service.MayTinhService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MayTinhServiceImpl implements MayTinhService {

    @Autowired
    private MayTinhRepository mayTinhRepository;

    @Override
    public Page<MayTinh> getData(int page) {
        Pageable pageable = PageRequest.of(page, 5);
        return mayTinhRepository.findAll(pageable);
    }

    @Override
    public void add(MayTinh mayTinh) {
        mayTinhRepository.save(mayTinh);
    }

    @Override
    public void delete(String id) {
        mayTinhRepository.deleteById(UUID.fromString(id));
    }

    @Override
    public void update(String id, MayTinh mayTinh) {
        MayTinh findMayTinh = mayTinhRepository.findById(UUID.fromString(id)).orElse(null);
        mayTinh.setId(findMayTinh.getId());
        BeanUtils.copyProperties(mayTinh, findMayTinh);
//        findMayTinh.setGia(mayTinh.getGia());
        mayTinhRepository.save(findMayTinh);
    }

    @Override
    public MayTinh findById(String id) {
        return mayTinhRepository.findById(UUID.fromString(id)).orElse(null);
    }
}
