package com.poly.hangnt169.service.impl;

import com.poly.hangnt169.entity.Hang;
import com.poly.hangnt169.repository.HangRepository;
import com.poly.hangnt169.service.HangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HangServiceImpl implements HangService {

    @Autowired
    private HangRepository hangRepository;

    @Override
    public List<Hang> getAll() {
        return hangRepository.findAll();
    }

    @Override
    public Hang findByID(String id) {
        return hangRepository.findById(UUID.fromString(id)).get();
    }
}
