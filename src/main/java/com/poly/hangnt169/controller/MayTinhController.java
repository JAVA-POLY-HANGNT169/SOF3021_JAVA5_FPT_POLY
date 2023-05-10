package com.poly.hangnt169.controller;

import com.poly.hangnt169.entity.Hang;
import com.poly.hangnt169.entity.MayTinh;
import com.poly.hangnt169.service.HangService;
import com.poly.hangnt169.service.MayTinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/may-tinh/")
public class MayTinhController {

    @Autowired
    private MayTinhService mayTinhService;

    @Autowired
    private HangService hangService;

    @GetMapping("hien-thi")
    public String getAll(@RequestParam(defaultValue = "0", name = "page") int number, Model model) {
        Page<MayTinh> listMayTinh = mayTinhService.getData(number);
        model.addAttribute("listMayTinh", listMayTinh);
        List<Hang>hangs = hangService.getAll();
        model.addAttribute("hangs", hangs);
        return "index";
    }

    @GetMapping("detail/{id}")
    public String detail(@PathVariable("id") String id, Model model) {
        MayTinh mayTinh = mayTinhService.findById(id);
        Page<MayTinh> listMayTinh = mayTinhService.getData(0);
        List<Hang>hangs = hangService.getAll();
        model.addAttribute("hangs", hangs);
        model.addAttribute("mayTinh", mayTinh);
        model.addAttribute("listMayTinh", listMayTinh);
        return "index";
    }

    @GetMapping("view-update/{id}")
    public String viewUpdate(@PathVariable("id") String id, Model model) {
        List<Hang>hangs = hangService.getAll();
        model.addAttribute("hangs", hangs);
        MayTinh mayTinh = mayTinhService.findById(id);
        model.addAttribute("mayTinh", mayTinh);
        return "view-update";
    }

    @PostMapping("add")
    public String addMayTinh(@RequestParam("ma") String ma, @RequestParam("ten") String ten,
                             @RequestParam("gia") String gia, @RequestParam("boNho") String boNho,
                             @RequestParam("mauSac") String mauSac, @RequestParam("hang") String hangID,
                             @RequestParam("moTa") String moTa) {
        Hang hang = hangService.findByID(hangID);
        MayTinh mayTinh = MayTinh.builder()
                .ma(ma)
                .boNho(boNho)
                .ten(ten)
                .gia(Float.valueOf(gia))
                .hang(hang)
                .mauSac(mauSac)
                .mieuTa(moTa)
                .build();
        mayTinhService.add(mayTinh);
        return "redirect:/may-tinh/hien-thi";
    }

    @PostMapping("update")
    public String updateMayTinh(@RequestParam("id") String id, @RequestParam("ma") String ma, @RequestParam("ten") String ten,
                                @RequestParam("gia") String gia, @RequestParam("boNho") String boNho,
                                @RequestParam("mauSac") String mauSac, @RequestParam("hang") String hangID,
                                @RequestParam("moTa") String moTa) {
        Hang hang = hangService.findByID(hangID);
        MayTinh mayTinh = MayTinh.builder()
                .ma(ma)
                .boNho(boNho)
                .ten(ten)
                .gia(Float.valueOf(gia))
                .hang(hang)
                .mauSac(mauSac)
                .mieuTa(moTa)
                .build();
        mayTinhService.update(id, mayTinh);
        return "redirect:/may-tinh/hien-thi";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") String id) {
        mayTinhService.delete(id);
        return "redirect:/may-tinh/hien-thi";
    }

}
