package com.aishervice.controllers;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aishervice.entities.Kendaraan;
import com.aishervice.repository.KendaraanRepository;
import com.aishervice.service.KendaraanService;

import org.springframework.ui.Model;
@Controller
public class KendaraanController {
    
  private KendaraanService kendaraanService;

    public KendaraanController() {
        this.kendaraanService = new KendaraanService(new KendaraanRepository());
    }
    
    @GetMapping("/kendaraan")
    public String kendaraan(Model model){
        try {

            ArrayList<Kendaraan> kendaraans = this.kendaraanService.getAllData();
            model.addAttribute("currentPage", "kendaraan");
            model.addAttribute("kendaraans", kendaraans);

            
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "kendaraan";
    }

    @PostMapping("/kendaraan")
    public String tambahKendaraan(@RequestParam("id_pelanggan") int id_pelanggan ,@RequestParam("no_plat") String no_plat, @RequestParam("nomor_mesin") String nomor_mesin, @RequestParam("jenis_kendaraan") String jenis_kendaraan, RedirectAttributes redirectAttributes) {
        try {
            Kendaraan kendaraan = new Kendaraan(id_pelanggan, no_plat, nomor_mesin, jenis_kendaraan);
            this.kendaraanService.insertData(kendaraan);
            redirectAttributes.addFlashAttribute("success", "Data berhasil ditambahkan!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/kendaraan";
    }

}
