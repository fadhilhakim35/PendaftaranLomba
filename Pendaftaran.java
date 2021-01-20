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
    private StringProperty nama_lomba;
    private IntegerProperty Harga;
    
    public Lomba(String nama_lomba){
        this.id_lomba = new SimpleIntegerProperty ();
        this.nama_lomba = new SimpleStringProperty (nama_lomba);
    }
    
    public abstract StringProperty NamaProperty();
    public abstract IntegerProperty HargaProperty();
    
}
