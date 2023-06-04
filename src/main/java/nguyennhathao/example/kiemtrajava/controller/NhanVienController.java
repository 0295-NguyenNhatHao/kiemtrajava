package nguyennhathao.example.kiemtrajava.controller;


import jakarta.validation.Valid;
import nguyennhathao.example.kiemtrajava.entity.NhanVien;
import nguyennhathao.example.kiemtrajava.services.NhanVienService;
import nguyennhathao.example.kiemtrajava.services.PhongBanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/nhanviens")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private PhongBanService phongBanService;
    @GetMapping
    public String ShowAllNhanVien(Model model)
    {
        List<NhanVien> nhanviens =nhanVienService.getAllNhanVien();
        model.addAttribute("nhanviens",nhanviens);
        return "nhanvien/list";
    }
    @GetMapping("/add")
    public String addBookForm(Model model){
        model.addAttribute("nhanvien", new NhanVien());
        model.addAttribute("phongbans",phongBanService.getAllPhongBan());
        return "nhanvien/add";
    }
    @PostMapping("/add")
    public String addBook(@ModelAttribute("nhanvien") NhanVien nhanVien){
        nhanVienService.addNhanVien(nhanVien);
        return "redirect:/nhanviens";

    }
    @GetMapping("/edit/{id}")
    public String editNhanVienForm(@PathVariable("id") String id, Model model){
        NhanVien editNhanVien = nhanVienService.getNhanVienById((id));
        if(editNhanVien != null){
            model.addAttribute("nhanvien", editNhanVien);
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editBook(@Valid @ModelAttribute("nhanvien")NhanVien updatenhanVien, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("phongbans", phongBanService.getAllPhongBan());
            return "nhanvien/edit";
        }
        nhanVienService.getAllNhanVien().stream()
                .filter(nhanvien -> nhanvien.getMa_NV().equals(updatenhanVien.getMa_NV()))
                .findFirst()
                .ifPresent(nhanvien -> {

                    nhanVienService.updateNhanVien(updatenhanVien);
                });
        return "redirect:/nhanviens";
    }
    @GetMapping("/delete/{id}")
    public String deleteNhanVien(@PathVariable("id")String id){
        Iterator<NhanVien> iterator = nhanVienService.getAllNhanVien().iterator();
        while (iterator.hasNext()){
            NhanVien nhanVien = iterator.next();
            if(nhanVien.getMa_NV().equals(id)){

                nhanVienService.deleteNhanVien(id);
                break;}
        }
        return "redirect:/nhanviens";
    }



}
