package com.poly.hangnt169.service;

import com.poly.hangnt169.entity.Hang;

import java.util.List;

public interface HangService {

    List<Hang>getAll();

    Hang findByID(String id);

}
