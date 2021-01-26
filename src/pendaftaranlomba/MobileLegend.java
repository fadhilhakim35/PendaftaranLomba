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
//subclass lomba
public class MobileLegend extends Lomba {
    IntegerProperty id;
    StringProperty nama;
    IntegerProperty Harga;
    
    public MobileLegend(String nama) {
        super(nama);
        super.setID(2);
        super.setHarga(100000);
        this.nama = new SimpleStringProperty (nama);
        this.Harga = new SimpleIntegerProperty(100000);
    } //constructor
    
    @Override
    public StringProperty NamaProperty() {
        return this.nama;
    } //inheritance

    @Override
    public IntegerProperty HargaProperty() {
        return this.Harga;
    }

}
