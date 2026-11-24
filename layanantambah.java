package projekPemdas;
import java.util.Scanner;

public class layanantambah {

    private String idLayanan;
    private String namaLayanan;
    private double harga;

    public layanantambah(String idLayanan, String namaLayanan, double harga) {
        this.idLayanan = idLayanan;
        this.namaLayanan = namaLayanan;
        this.harga = harga;
    }

    public String getIdLayanan() {
        return idLayanan;
    }

    public String getNamaLayanan() {
        return namaLayanan;
    }

    public double getHarga() {
        return harga;
    }

    public void setNamaLayanan(String namaLayanan) {
        this.namaLayanan = namaLayanan;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void tampilkanInfo() {
        System.out.println("ID Layanan   : " + idLayanan);
        System.out.println("Nama Layanan : " + namaLayanan);
        System.out.println("Harga        : Rp " + harga);
    }

    public static void main(String[] args) {

        layanantambah layanan1 =
            new layanantambah("L001", "Breakfast", 50000);

        layanantambah layanan2 =
            new layanantambah("L002", "Laundry", 30000);

        layanantambah layanan3 =
            new layanantambah("L003", "Sauna", 75000);

        layanantambah layanan4 =
            new layanantambah("L004", "Spa", 150000);

        layanantambah layanan5 =
            new layanantambah("L005", "Meeting Room", 300000);

        System.out.println("================================");
        System.out.println("     DAFTAR LAYANAN TAMBAHAN");
        System.out.println("================================");

        layanan1.tampilkanInfo();
        System.out.println("-------------------------------");

        layanan2.tampilkanInfo();
        System.out.println("-------------------------------");

        layanan3.tampilkanInfo();
        System.out.println("-------------------------------");

        layanan4.tampilkanInfo();
        System.out.println("-------------------------------");

        layanan5.tampilkanInfo();
        System.out.println("-------------------------------");
    }
}