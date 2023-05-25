// package com.aishervice.controllers;
// import java.security.Timestamp;
// import java.util.ArrayList;

// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import com.aishervice.entities.Progress;
// import com.aishervice.repository.ProgressRepository;
// import com.aishervice.service.ProgressService;

// import org.springframework.ui.Model;
// @Controller
// public class ProgressController {
    
//     private ProgressService progressService;

//     public ProgressController() {
//         this.progressService = new ProgressService(new ProgressRepository());
//     }
    
//     @GetMapping("/progress")
//     public String progress(Model model){
//         try {

//             ArrayList<Progress> progressArray = this.progressService.getAllData();
//             model.addAttribute("currentPage", "progress");
//             model.addAttribute("progressArray", progressArray);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         return "progress";
//     }

//     @PostMapping("/inventaris")
//     public String tambahPelanggan(@RequestParam("id_service") int id_service, @RequestParam("catatan_proses") String catatan_proses, @RequestParam("waktu_progress") java.sql.Timestamp waktu_progress, RedirectAttributes redirectAttributes) {
//         try {
//             Progress progress = new Progress(id_service, catatan_proses, waktu_progress);
//             this.progressService.insertData(progress);
//             redirectAttributes.addFlashAttribute("success", "Data berhasil ditambahkan!");
//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//         return "redirect:/inventaris";
//     }
// }
