package projekPemdas;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Kamar> daftarKamarHotel = new ArrayList<>();
        daftarKamarHotel.add(new Kamar("101", "Standard", 300000));
        daftarKamarHotel.add(new Kamar("201", "Deluxe", 500000));
        daftarKamarHotel.add(new Kamar("301", "Suite", 850000));

        ArrayList<layanantambah> daftarLayananHotel = new ArrayList<>();
        daftarLayananHotel.add(new layanantambah("L001","Breakfast", 50000));
        daftarLayananHotel.add(new layanantambah("L002","Laundry", 30000));
        daftarLayananHotel.add(new layanantambah("L003","Sauna", 75000));
        daftarLayananHotel.add(new layanantambah("L004","Spa", 150000));
        daftarLayananHotel.add(new layanantambah("L005","Meeting Room", 300000));

        Reservasi reservasiAktif = null;
        Pembayaran pembayaranAktif = null;
        int pilihanMenu = 0;
        int noBook = 1;
        int noCust = 1;
        int noBayar = 1;
        ArrayList<Reservasi> daftarReservasi = new ArrayList<>();

        while (pilihanMenu != 6) {
            System.out.println("\n=========================");
            System.out.println("SISTEM BOOKING HOTEL OOP JAVA");
            System.out.println("=========================");
            System.out.println("1. Lihat Daftar Kamar");
            System.out.println("2. Buat Reservasi Baru");
            System.out.println("3. Lihat Detail Reservasi");
            System.out.println("4. Proses Pembayaran & Cetak Struk");
            System.out.println("5. Keluar");
            System.out.println("Pilih menu (1-5): ");
            pilihanMenu = input.nextInt();
            input.nextLine();
            
        switch(pilihanMenu){
            case 1:
                System.out.println("\n---DAFTAR KAMAR HOTEL --- ");
                for (Kamar k:daftarKamarHotel){
                    k.tampilkanInfo();
                }
                break;
            case 2:
                System.out.println("\n---BUAT RESERVASI BARU ---");
                String idCust = String.format("C%1d",noCust);
                noCust++;
                System.out.println("ID Customer    :"+idCust);
                System.out.print("Nama Customer  : ");
                String nama = input.nextLine();
                System.out.print("No. HP         : ");
                String noHp = input.nextLine();

                Customer custBaru = new Customer (idCust,nama,noHp);
                String kodeBook=String.format("A%03d",noBook);
                noBook++;
                System.out.println("Kode Booking Anda: "+kodeBook);
                System.out.println("Tanggal check-in (YYYY-MM-DD): ");
                LocalDate checkIn = LocalDate.parse(input.nextLine());
                System.out.println("Lama Inap (malam): ");
                int lamaInap = input.nextInt();
                input.nextLine();

                LocalDate checkOut = checkIn.plusDays(lamaInap);
                System.out.println("Tanggal check-out: "+checkOut);
                
                reservasiAktif = new Reservasi(kodeBook, custBaru, checkIn,lamaInap);

                String tambahKamar2 = "y";
                while (tambahKamar2.equalsIgnoreCase("y")){
                    System.out.println("\nPilih Nomor Kamar yang tersedia: ");
                    for (Kamar k : daftarKamarHotel){
                        if(k.isTersedia()){
                            k.tampilkanInfo();
                        }
                    }
                    System.out.println("Masukkan Nomor Kamar: ");
                    String pilihNoKamar = input.nextLine();

                    boolean kamarValid = false;
                    boolean kamarBentrok = false;
                    for (Kamar k:daftarKamarHotel){
                        if (k.getNomorKamar().equalsIgnoreCase(pilihNoKamar)){
                            
                            for(Reservasi r: daftarReservasi){
                                if (r.bentrok(pilihNoKamar, checkIn, checkOut)){
                                    kamarBentrok = true;
                                    System.out.println("Kamar "+pilihNoKamar+ " akan penuh sampai tanggal "+r.getTglCheckOut());

                                    System.out.println("Kamar akan kembali tersedia mulai tanggal "+r.getTglCheckOut());
                                    break;
                                }
                            }
                            if(reservasiAktif.bentrok(nama, checkIn, checkOut)){
                                kamarBentrok = true;
                            }
                            if(!kamarBentrok){
                                reservasiAktif.tambahKamar(k);
                                kamarValid=true;
                                System.out.println("Kamar berhasil dipilih!");
                            }
                            break;
                        }
                    }
                    if (!kamarValid && !kamarBentrok){
                        System.out.println("Nomor kamar tidak valid.");
                    }

                    System.out.print("Tambah kamar lain dalam reservasi ini? (y/n): ");
                    tambahKamar2=input.nextLine();
                    }
                    System.out.println("Ingin menambahkan layanan tambahan untuk kamar ini? (y/n: )");
                    String tambahLayanan2 = input.nextLine();
                    while(tambahLayanan2.equalsIgnoreCase("y")){
                        System.out.println("\n Daftar Layanan Tambahan: ");
                        for(int i=0;i<daftarLayananHotel.size();i++){
                            System.out.println((i+1)+". ");
                            daftarLayananHotel.get(i).tampilkanInfo();
                        }
                        System.out.print("Pilih nomor layanan (1-"+daftarLayananHotel.size()+"): ");
                        int idxLayanan = input.nextInt()-1;
                        input.nextLine();
                        
                        if (idxLayanan>=0 && idxLayanan<daftarLayananHotel.size()){
                            reservasiAktif.tambahLayanan(daftarLayananHotel.get(idxLayanan));
                            System.out.println("Layanan berhasil ditambahkan!");
                        } else{
                            System.out.println("Pilihan layanan tidak valid.");
                        }

                        System.out.print("Tambah layanan lain? (y/n): ");
                        tambahLayanan2 = input.nextLine();
                    }
                    daftarReservasi.add(reservasiAktif);
                    System.out.println("\nReservasi berhasil dibuat!");
                    break;
                
            case 3 : 
                if (reservasiAktif != null) {
                    reservasiAktif.tampilkanDetail();
                } else {
                    System.out.println("\nBelum ada reservasi yang dibuat.");
                }
                
                break;
            case 4 :
                if (reservasiAktif != null ) {
                    System.out.println("\n--- PROSES PEMBAYARAN---");
                    System.out.println("Total Tagihan : Rp" + reservasiAktif.hitungTotalTagihan());
                    String idPembayaran=String.format("BAYAR%03d", noBayar);
                    noBayar++;
                    System.out.println("ID Pembayaran : "+idPembayaran);
                    System.out.println("Metode Bayar (Cash/Transfer/QR) : ");
                    String metode = input.nextLine();

                    pembayaranAktif = new Pembayaran(idPembayaran, reservasiAktif, metode);
                    
                    System.out.print("Masukkan Nominal Uang Bayar : Rp");
                    double uangBayar = input.nextDouble();
                    input.nextLine();

                    pembayaranAktif.prosesBayar(uangBayar);
                    
                } else {
                    System.out.println("\nBuat reservasi terlebih dahulu di menu 3.");
                }
                break;
                
                
            case 5 :
                System.out.println("Terimakasih telah melakukan booking di hotel kami");
                break;

            default :
                System.out.println("Pilihan tidak valid. Silakan masukkan pilihan nomor 1-6!");
            }       
        }
        input.close();
    }
}