/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaranlomba;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ACER
 */
public class PendaftaranLombaDataModel {

    public final Connection CONN;

    public PendaftaranLombaDataModel(String driver) throws SQLException {
        this.CONN = koneksi.koneksi(driver);
    }

    public void inputData(Pendaftaran Pendaftaran) throws SQLException {
        String insertPengguna = "INSERT INTO pengguna (ID,Nama,alamat,no_hp)"
                + " VALUES (?,?,?,?)";
        String insertPendaftaran = "INSERT INTO pendaftaran (id,id_pengguna,nama_pengguna,"
                + "id_lomba,nama_lomba)"
                + " VALUES (?,?,?,?,?)";
        String insertLomba = "INSERT INTO lomba (id,id_lomba,nama_lomba,harga)"
                + " VALUES (?,?,?,?)";

        PreparedStatement stmtPengguna = CONN.prepareStatement(insertPengguna);
        stmtPengguna.setInt(1, Pendaftaran.getID());
        stmtPengguna.setString(2, Pendaftaran.pengguna.getNama());
        stmtPengguna.setString(3, Pendaftaran.pengguna.getAlamat());
        stmtPengguna.setString(4, Pendaftaran.pengguna.getNohp());
        stmtPengguna.execute();
        
        PreparedStatement stmtLomba = CONN.prepareStatement(insertLomba);
        stmtLomba.setInt(1, Pendaftaran.getID());
        stmtLomba.setInt(2, Pendaftaran.lomba.getID());
        stmtLomba.setString(3, Pendaftaran.lomba.getNama());
        stmtLomba.setInt(4, Pendaftaran.lomba.getHarga());
        stmtLomba.execute();
        
        PreparedStatement stmtPendaftaran = CONN.prepareStatement(insertPendaftaran);
        stmtPendaftaran.setInt(1, Pendaftaran.getID());
        stmtPendaftaran.setInt(2, Pendaftaran.getID());
        stmtPendaftaran.setString(3, Pendaftaran.pengguna.getNama());
        stmtPendaftaran.setInt(4, Pendaftaran.getID());
        stmtPendaftaran.setString(5, Pendaftaran.lomba.getNama());
        stmtPendaftaran.execute();
        
       
        

    }

    

    public ObservableList getData() throws SQLException {
        ObservableList<Pendaftaran> data = FXCollections.observableArrayList();
        MobileLegend MobileLegend;
        PUBG pubg;
        
        String sqlPengguna = "SELECT * FROM `pengguna`";
        String sqlPendaftaran = "SELECT * FROM `pendaftaran`";
        String sqlLomba = "SELECT * FROM `lomba`";
        String sqlML = "SELECT * FROM `mobilelegend`";
        String sqlPUBG = "SELECT * FROM `pubg`";


        try {
            ResultSet rsPengguna = CONN.createStatement().executeQuery(sqlPengguna);
            ResultSet rsPendaftaran = CONN.createStatement().executeQuery(sqlPendaftaran);
            ResultSet rsLomba = CONN.createStatement().executeQuery(sqlLomba);
            ResultSet rsML = CONN.createStatement().executeQuery(sqlML);
            ResultSet rsPUBG = CONN.createStatement().executeQuery(sqlPUBG);
            
            while (rsPengguna.next() && rsPendaftaran.next() && rsLomba.next()) {
                if (rsLomba.getString("nama_lomba").equals("Mobile Legend")) {
                    rsML.absolute(1);
                    MobileLegend = new MobileLegend(
                            rsML.getString("nama"));
                    
                    data.add(new Pendaftaran(rsPendaftaran.getInt("id"),
                            new Pengguna (rsPengguna.getString("nama"),
                            rsPengguna.getString("alamat"),
                            rsPengguna.getString("no_hp")),
                            MobileLegend
                            ));
                } else {
                    rsPUBG.absolute(1);
                    pubg = new PUBG(
                            rsPUBG.getString("nama"));
                    
                    data.add(new Pendaftaran(rsPendaftaran.getInt("id"),
                            new Pengguna (rsPengguna.getString("nama"),
                            rsPengguna.getString("alamat"),
                            rsPengguna.getString("no_hp")),
                            pubg
                            ));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PendaftaranLombaDataModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    public int ID() throws SQLException {
        String sql = "SELECT MAX(id) from pendaftaran";
        ResultSet rs = CONN.createStatement().executeQuery(sql);
        while (rs.next()) {
            return rs.getInt(1) == 0 ? 1289461 : rs.getInt(1) + 1;
        }
        return 1289461;
    }
}
