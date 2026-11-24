package projekPemdas;
import java.util.ArrayList;
import java.time.LocalDate;

public class Reservasi {
    private String kodeBooking;
    private Customer customer;
    private ArrayList<Kamar> daftarKamar = new ArrayList<>();
    private ArrayList<layanantambah> daftarLayanan = new ArrayList<>();
    private int lamaMenginap;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservasi(String kodeBooking, Customer customer, LocalDate checkIn, int lamaMenginap) {
        this.kodeBooking = kodeBooking;
        this.customer = customer;
        this.checkIn = checkIn;
        this.lamaMenginap = lamaMenginap;
        this.checkOut = checkIn.plusDays(lamaMenginap);
    }

    public String getKodeBooking() {
        return kodeBooking;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void tambahKamar(Kamar kamar) {
        daftarKamar.add(kamar);
    }

    public void tambahLayanan(layanantambah layanan) {
        daftarLayanan.add(layanan);
    }

    public double hitungTotalTagihan() {
        double total = 0;
        for (Kamar k : daftarKamar) {
            total += k.getHargaPerMalam() * lamaMenginap;
        }
        for (layanantambah l : daftarLayanan) {
            total += l.getHarga();
        }
        return total;
    }

    public void tampilkanDetail() {
        System.out.println("Kode Booking  : " + kodeBooking);
        customer.tampilkanProfil();
        for (Kamar k : daftarKamar) {
            k.tampilkanInfo();
        }
        for (layanantambah l : daftarLayanan) {
            System.out.println("Layanan       : " + l.getNamaLayanan() + " (Rp" + l.getHarga() + ")");
        }
        System.out.println("Lama menginap : " + lamaMenginap + " malam");
        System.out.println("Total Tagihan : Rp" + hitungTotalTagihan());
        System.out.println("Tanggal Check Out : " + checkOut);
    }

    public boolean bentrok(String nomorKamar, LocalDate checkInBaru, LocalDate checkOutBaru){

        for (Kamar k : daftarKamar){
            if(k.getNomorKamar().equalsIgnoreCase(nomorKamar)){
                return checkInBaru.isBefore(checkOut) && checkOutBaru.isAfter(checkIn);
            }
        }
    return false;
    }
    public LocalDate getTglCheckOut(){
        return checkOut;
    }
}