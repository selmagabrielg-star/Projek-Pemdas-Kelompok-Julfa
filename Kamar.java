package projekPemdas;
public class Kamar {
    private String nomorKamar;
    private String tipeKamar;
    private double hargaPerMalam;
    private boolean tersedia;

    public Kamar(String nomorKamar, String tipeKamar, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        setHargaPerMalam(hargaPerMalam);
        this.tersedia = true;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public void setHargaPerMalam(double hargaPerMalam) {
        if (hargaPerMalam > 0) {
            this.hargaPerMalam = hargaPerMalam;
        } else {
            System.out.println("Gagal: Harga kamar harus lebih dari Rp0.");
        }
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void tampilkanInfo() {
        String status = tersedia ? "Tersedia" : "Terisi";
        System.out.println("Kamar " + nomorKamar + " (" + tipeKamar + ") - Rp" + hargaPerMalam + "/malam [" + status + "]");
    }
}
