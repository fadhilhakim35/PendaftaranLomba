# Final Project PBO

'SI Pendaftaran Lomba' merupakan Sistem Informasi yang dapat digunakan untuk menginput data Pendaftaran Lomba yang dikhususkan untuk Lomba e-Sport terutama Mobile Legend dan PUBG Mobile di Lampung.


M.Fadhil Hakim 1957051014
Devi Ramadhia Fitri 1917051005
Sendy Pramita 1917051030

Untuk pembagian tugas Final Project dikerjakan bersama-sama

### Class Diagram
```mermaid
classDiagram

    Pendaftaran -- Lomba
    Pengguna -- Pendaftaran
    Lomba <|-- MobileLegend
    Lomba <|-- PUBG
    class Lomba {
    <<abstract>>
        +int id
        +String nama
        +int Harga
        +setNama()
        +setHarga()
        +getHarga()* int
        +getNama() string
        }
    class MobileLegend{
      +MobileLegend(String nama)
      +getHarga()* int
    }
    class PUBG{
      +PUBG(String nama)
      +getHarga()* int
    }
   class Pengguna{
      +Pengguna(String nama,String alamat,String no_hp)
      +String nama
      +String alamat
      +String no_hp
      +getNama() String
      +getAlamat() String
      +getNoHp() String
   }
   class Pendaftaran{
      +int id
      +Pengguna pengguna
      +Lomba lomba
      +Pendaftaran(int id,Pengguna pengguna,Lomba lomba)
      +getID() int
   }
```

### ER Diagram
```mermaid
erDiagram
          Pengguna }|..|{ Pendaftaran : do
          Pendaftaran }|--|| Lomba : has
          Lomba ||--|| MobileLegend : is
          Lomba ||--|| PUBG : is

        Pengguna{
            String nama
            String alamat
            String no_hp
          }
         Pendaftaran {
            int id
            Pengguna pengguna
            Lomba lomba
          }
          Lomba{
            int id
            String nama
            int Harga
          }
          MobileLegend{
            String nama
            int Harga
          }
          PUBG{
            String nama
            int Harga
          }
```
### Design Class Diagram for JavaFX and Database
```mermaid
classDiagram
    Lomba <|-- MobileLegend
    Lomba <|-- PUBG
    Lomba -- Pendaftaran
    Pengguna "*".."1" Pendaftaran : do
    Pendaftaran o-- PendaftaranLombaDataModel : Data Modeling
    PendaftaranLombaDataModel --> koneksi : DB Connection

    class Lomba{
      <<abstract>>
        -StringProperty Nama
        -IntegerProperty id_lomba
        -IntegerProperty Harga
    }
    
    class MobileLegend{
        StringProperty nama
        IntegerProperty Harga
    }
    class PUBG{
        StringProperty nama
        IntegerProperty Harga
    }
    class Pengguna{
        -StringProperty Nama
        -StringProperty alamat
        -StringProperty no_hp
    }
    class Pendaftaran{
        IntegerProperty ID
        Pengguna pengguna
        Lomba lomba
    }

    class PendaftaranLombaDataModel{
        Connection CONN
        inputData(Pendaftaran pendaftaran)
        getData()
        ID()
    }

    class koneksi{
        - String user
        - String pass
        - String MYSQLhost
        koneksi(String driver)
    }
```
Link Youtube : penjelasan
