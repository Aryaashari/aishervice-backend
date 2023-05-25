package com.aishervice.controllers;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aishervice.entities.Inventaris;
import com.aishervice.repository.InventarisRepository;
import com.aishervice.service.InventarisService;

import org.springframework.ui.Model;
@Controller
public class InventarisController {

    private InventarisService inventarisService;

    public InventarisController() {
        this.inventarisService = new InventarisService(new InventarisRepository());
    }
    
    @GetMapping("/inventaris")
    public String inventaris(Model model){
        try {

            ArrayList<Inventaris> inventarisArray = this.inventarisService.getAllData();
            model.addAttribute("currentPage", "inventaris");
            model.addAttribute("inventarisArray", inventarisArray);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "inventaris";
    }

    @PostMapping("/inventaris")
    public String tambahInventaris(@RequestParam("suku_cadang") String suku_cadang, @RequestParam("stok") int stok, @RequestParam("harga_satuan") float harga_satuan, RedirectAttributes redirectAttributes) {
        try {
            Inventaris inventaris = new Inventaris(suku_cadang, stok, harga_satuan);
            this.inventarisService.insertData(inventaris);
            redirectAttributes.addFlashAttribute("success", "Data berhasil ditambahkan!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/inventaris";
    }

    @PostMapping("/inventaris/{id}/tambah-stok")
    public String tambahStok(@PathVariable("id") int id, @RequestParam("jumlahStok") int jumlahStok, RedirectAttributes redirectAttributes) {
        try {
            Inventaris inventaris = inventarisService.getDataByIdInventaris(id);
            if (inventaris != null) {
                inventaris.setStok(inventaris.getStok() + jumlahStok);
                inventarisService.updateStok(inventaris);
                redirectAttributes.addFlashAttribute("success", "Stok berhasil ditambahkan!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Data inventaris tidak ditemukan.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/inventaris";
    }

    @PostMapping("/inventaris/{id}/kurangi-stok")
    public String kurangiStok(@PathVariable("id") int id, @RequestParam("jumlahStok") int jumlahStok, RedirectAttributes redirectAttributes) {
        try {
            Inventaris inventaris = inventarisService.getDataByIdInventaris(id);
            if (inventaris != null) {
                inventaris.setStok(inventaris.getStok() - jumlahStok);
                inventarisService.updateStok(inventaris);
                redirectAttributes.addFlashAttribute("success", "Stok berhasil dikurangi!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Data inventaris tidak ditemukan.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/inventaris";
    }
    
}
