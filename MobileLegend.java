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
public class MobileLegend extends Lomba {
    private StringProperty nama;
    private IntegerProperty Harga;
    
    public MobileLegend(String nama) {
        super(nama);
        this.nama = new SimpleStringProperty (nama);
        this.Harga = new SimpleIntegerProperty(100000);
    }
    
    @Override
    public StringProperty NamaProperty() {
        return this.nama;
    }

    @Override
    public IntegerProperty HargaProperty() {
        return this.Harga;
    }
    
}
