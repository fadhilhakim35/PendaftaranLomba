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
public class PUBG extends Lomba {
    StringProperty nama;
    IntegerProperty Harga;
    
    public PUBG (String nama) {
        super(nama);
        this.nama = new SimpleStringProperty (nama);
        this.Harga = new SimpleIntegerProperty (150000);
    }
    
    @Override
    public StringProperty NamaProperty() {
        return nama;
    }

    @Override
    public IntegerProperty HargaProperty() {
        return Harga;
    }

    
}
