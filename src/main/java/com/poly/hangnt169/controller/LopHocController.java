package com.poly.hangnt169.controller;

import com.poly.hangnt169.entity.Lop;
import com.poly.hangnt169.request.LopHocRequest;
import com.poly.hangnt169.response.LopResponse;
import com.poly.hangnt169.service.LopService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author hangnt169
 */
@Controller
@RequestMapping("/lop-hoc/")
public class LopHocController {

    @Autowired
    private LopService lopService;

    @GetMapping("hien-thi")
    public String hienThiDanhSachLopHoc(Model model) {
        List<LopResponse> lops = lopService.hienThiDanhSachLop();
        model.addAttribute("lops", lops);
        model.addAttribute("lopHoc", new Lop());
        return "lophoc/lop-hoc";
    }

    @GetMapping("detail/{id}")
    public String detailLopHoc(@PathVariable("id") Long id, Model model) {
        LopResponse lop = lopService.detailLopHoc(id);
        List<LopResponse> lops = lopService.hienThiDanhSachLop();
        model.addAttribute("lopHoc", lop);
        model.addAttribute("lops", lops);
        return "lophoc/lop-hoc";
    }

    @GetMapping("delete/{id}")
    public String deleteLopHoc(@PathVariable("id") Long id, Model model) {
        lopService.removeLopHoc(id);
        List<LopResponse> lops = lopService.hienThiDanhSachLop();
        model.addAttribute("lops", lops);
        model.addAttribute("lopHoc", new Lop());
        return "lophoc/lop-hoc";
    }

    @PostMapping("add-update")
    public String addOrUpdateLopHoc(@Valid @ModelAttribute("lopHoc") LopHocRequest request, Model model, BindingResult result) {
        if (result.hasErrors()) {
            List<LopResponse> lops = lopService.hienThiDanhSachLop();
            model.addAttribute("lops", lops);
            return "lophoc/lop-hoc";
        }
        lopService.addOrUpdateLopHoc(request);
        return "redirect:/lop-hoc/hien-thi";
    }
}
