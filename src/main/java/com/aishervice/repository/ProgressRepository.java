// package com.aishervice.repository;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.util.ArrayList;
// import com.aishervice.config.database;
// import com.aishervice.entities.Progress;

// public class ProgressRepository {
//     private Connection conn;

//     public ProgressRepository() {
//         this.conn = database.getConnection("prod");
//     }

//     public ArrayList<Progress> findAll() throws Exception {
//         String syntax = "SELECT id_proses, id_service, catatan_proses, waktu_progress FROM progress";

//         try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {
             
//             ResultSet result = pstmt.executeQuery();

//             ArrayList<Progress> ProgressArray = new ArrayList<Progress>();
//             Progress objProgress;
//             while (result.next()) {
//                 objProgress = new Progress(result.getInt("id_service"), result.getString("catatan_proses"), result.getTimestamp("waktu_progress"));
//                 objProgress.setId_proses(result.getInt("id_proses"));
//                 ProgressArray.add(objProgress);
//             }

//             return ProgressArray;

//         } catch (Exception e) {
//             throw e;
//         }
//     }

//     public Progress findByIdProses(int id_proses) throws Exception {
//         String syntax = "SELECT id_proses, id_service, catatan_proses, waktu_progress FROM progress WHERE id_proses=?";

//         try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {

//             pstmt.setInt(1, id_proses);

//             ResultSet result = pstmt.executeQuery();
//             Progress objProgress = null;
//             if (result.next()) {
//                 objProgress = new Progress(result.getInt("id_service"), result.getString("catatan_proses"), result.getTimestamp("waktu_progress"));
//                 objProgress.setId_proses(result.getInt("id_proses"));
//             }

//             return objProgress;

//         } catch (Exception e) {
//             throw e;
//         }
//     }


//     public Progress store(Progress objProgress) throws Exception {

//         String syntax = "INSERT INTO progress(id_service, catatan_proses, waktu_progress) VALUES(?,?,?)";

//         try (PreparedStatement pstmt = this.conn.prepareStatement(syntax)) {

//             pstmt.setInt(1, objProgress.getId_service());
//             pstmt.setString(2, objProgress.getCatatan_proses());
//             pstmt.setTimestamp(3, objProgress.getWaktu_progress());

//             int rowsInserted = pstmt.executeUpdate();

//             if (rowsInserted > 0) {
//                 ResultSet generatedKeys = pstmt.getGeneratedKeys();
//                 if (generatedKeys.next()) {
//                     int lastInsertedId = generatedKeys.getInt(1);
//                     objProgress.setId_proses(rowsInserted);(lastInsertedId);
//                 }
//             }

//             return objProgress;

//         } catch (Exception e) {
//             throw e;
//         }

//     }
// }
