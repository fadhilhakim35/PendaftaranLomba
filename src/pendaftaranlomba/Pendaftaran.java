/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaranlomba;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ACER
 */
public class Pendaftaran {
    IntegerProperty ID; //int
    Pengguna pengguna; //objek dari class pengguna
    Lomba lomba; //objek dari class lomba
    
    public Pendaftaran (int ID, Pengguna pengguna, Lomba lomba){
        this.ID = new SimpleIntegerProperty (ID);
        this.pengguna = pengguna;
        this.lomba = lomba;
    }
    
    public int getID(){
        return this.ID.get();
    }
    
    public IntegerProperty IDProperty(){
        return this.ID;
    }
    
    public StringProperty NamaProperty(){
        return pengguna.NamaProperty();
    }
    
    public StringProperty LombaProperty(){
        return lomba.NamaProperty();
    }
    
    public IntegerProperty HargaProperty(){
        return lomba.HargaProperty();
    }
}
