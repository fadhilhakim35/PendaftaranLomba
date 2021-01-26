/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pendaftaranlomba;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author ACER
 */
public class Main extends Application {
    
    TableView tab = new TableView();
    ObservableList Data = FXCollections.observableArrayList();
    TextField Nama = new TextField();
    TextField Alamat = new TextField();
    TextField no_hp = new TextField();
    ComboBox Lomba = new ComboBox();
    int id = 1;
    
    @Override
    public void start(Stage primaryStage) {
        
        Label judul = new Label();
        judul.setText("E-SPORT COMPETITION LAMPUNG");
        judul.setMinHeight(5);
        judul.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        
        Nama.setPromptText("Nama");
        Alamat.setPromptText("Alamat");
        no_hp.setPromptText("Nomor HP");
        
        Lomba.setPromptText("Daftar Lomba");
        Lomba.setMinWidth(150);
        Lomba.getItems().add("PUBG");
        Lomba.getItems().add("Mobile Legend");
        
        Button btn = new Button();
        btn.setText("Input Data");
        btn.setOnAction(new EventHandler<ActionEvent>() {
    
            @Override
            public void handle(ActionEvent event) {
                if (Lomba.getValue().toString().equals("PUBG")){
                    Data.add(new Pendaftaran(id,
                            new Pengguna(Nama.getText(),Alamat.getText(),no_hp.getText()),
                            new PUBG(Lomba.getValue().toString()))
                            );
                    id = id+1;
                }
                else if (Lomba.getValue().toString().equals("Mobile Legend")){
                    Data.add(new Pendaftaran(id,
                            new Pengguna(Nama.getText(),Alamat.getText(),no_hp.getText()),
                            new MobileLegend(Lomba.getValue().toString()))
                            );
                    id = id+1;
                }
                Nama.clear();
                Alamat.clear();
                no_hp.clear();
                Lomba.setValue(null);
                
            }
        });
        
        TableColumn colID = new TableColumn ("ID");
        colID.setCellValueFactory (new PropertyValueFactory<Pendaftaran,String>("ID"));
        colID.setMinWidth(100);
        
        TableColumn colNama = new TableColumn ("Nama");
        colNama.setCellValueFactory (new PropertyValueFactory<Pendaftaran,String>("Nama"));
        colNama.setMinWidth(100);
        
        TableColumn colLomba = new TableColumn ("Lomba");
        colLomba.setCellValueFactory (new PropertyValueFactory<Pendaftaran,String>("Lomba"));
        colLomba.setMinWidth(100);
        
        TableColumn colHarga = new TableColumn ("Harga");
        colHarga.setCellValueFactory (new PropertyValueFactory<Pendaftaran,String>("Harga"));
        colHarga.setMinWidth(100);
        
        tab.setItems(Data);
        tab.getColumns().setAll(colID,colNama,colLomba,colHarga);
        VBox Btabel = new VBox();
        VBox Bform = new VBox(10);
        GridPane root = new GridPane();
        root.add(Btabel, 0, 0,1,1);
        Btabel.getChildren().add(tab);
        root.add(Bform, 1, 0,1,1);
        Bform.getChildren().addAll(judul,Nama,
                Alamat,no_hp,Lomba,btn);
        Bform.setStyle("-fx-padding:10;");
        // root.getChildren().add(btn);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("E-Sport LPG"); // Dari Lampung Untuk Lampung
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
//        launch(args);
          
    }
}
