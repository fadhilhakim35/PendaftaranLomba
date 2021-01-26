/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaranlomba;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ACER
 */
public abstract class Lomba {
    private IntegerProperty id_lomba;
    private StringProperty nama;
    private IntegerProperty Harga;
    
    public Lomba(String nama_lomba){ //constructor
        this.id_lomba = new SimpleIntegerProperty ();
        this.nama = new SimpleStringProperty (nama_lomba);
        this.Harga = new SimpleIntegerProperty();
    }
    
    public void setID(int id){
        this.id_lomba.set(id);
    }
    
    public void setHarga(int hrg){
        this.Harga.set(hrg);
    }
    
    public int getID(){
        return this.id_lomba.get();
    }
    
    public String getNama(){
        return this.nama.get();
    }
    
    public int getHarga(){
        return this.Harga.get();
    }
    
    public abstract StringProperty NamaProperty();
    public abstract IntegerProperty HargaProperty();
    
    
}
