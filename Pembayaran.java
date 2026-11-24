package projekPemdas;
public class Pembayaran {
    private String idPembayaran;
    private Reservasi reservasi;
    private String metodeBayar;
    private boolean statusLunas;

    public Pembayaran(String idPembayaran, Reservasi reservasi, String metodeBayar) {
        this.idPembayaran = idPembayaran;
        this.reservasi = reservasi;
        this.metodeBayar = metodeBayar;
        this.statusLunas = false;
    }

    public void prosesBayar(double jumlahUang) {
        double tagihan = reservasi.hitungTotalTagihan();
        if (jumlahUang >= tagihan) {
            this.statusLunas = true;
            System.out.println("\nPembayaran Berhasil! Kembalian: Rp" + (jumlahUang - tagihan));
        } else {
            System.out.println("\nPembayaran Gagal! Uang kurang Rp" + (tagihan - jumlahUang));
        }
    }

    public void cetakStruk() {
        System.out.println("\n========== STRUK PEMBAYARAN ==========");
        System.out.println("ID Bayar     : " + idPembayaran);
        System.out.println("Kode Booking : " + reservasi.getKodeBooking());
        System.out.println("Pemesan      : " + reservasi.getCustomer().getNama());
        System.out.println("Metode       : " + metodeBayar);
        System.out.println("Total Bayar  : Rp" + reservasi.hitungTotalTagihan());
        System.out.println("Status       : " + (statusLunas ? "LUNAS" : "BELUM LUNAS"));
        System.out.println("======================================");
    }
}