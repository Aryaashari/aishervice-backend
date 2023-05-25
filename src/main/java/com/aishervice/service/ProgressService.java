// package com.aishervice.service;

// import java.util.ArrayList;

// import com.aishervice.entities.Progress;
// import com.aishervice.repository.ProgressRepository;
// public class ProgressService {
//     private ProgressRepository progressRepo;

//     public ProgressService(ProgressRepository progressRepo) {
//         this.progressRepo = progressRepo;
//     }

//     public ArrayList<Progress> getAllData() throws Exception {
//         try {
//             ArrayList<Progress> progressArray = this.progressRepo.findAll();
//             return progressArray;
//         } catch (Exception e) {
//             throw e;
//         }
//     }


//     public Progress getDataByIdProses(int id_proses) throws Exception {
//         try {
//             Progress progress = this.progressRepo.findByIdProses(id_proses);
//             return progress;
//         } catch (Exception e) {
//             throw e;
//         }
//     }

//     public Progress insertData(Progress progress) throws Exception {
//         try {

//             Progress result = this.progressRepo.store(progress);
//             return result;

//         } catch (Exception e) {
//             throw e;
//         }
//     }
// }
