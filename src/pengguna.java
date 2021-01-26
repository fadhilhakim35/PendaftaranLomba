/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaranlomba;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ACER
 */
public class Pengguna {
    private StringProperty Nama,Alamat,no_hp;
    
    public Pengguna(String Nama,String Alamat,String no_hp){
        this.Nama = new SimpleStringProperty (Nama);
        this.Alamat = new SimpleStringProperty(Alamat);
        this.no_hp = new SimpleStringProperty(no_hp);
    }
    
    public StringProperty NamaProperty(){
        return this.Nama;
    }
}
