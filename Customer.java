package projekPemdas;
public class Customer {
    private String idCust;
    private String nama;
    private String noHp;

    public Customer (String idCust, String nama, String noHp){
    this.idCust=idCust;
    this.nama = nama;
    this.noHp=noHp;
    }
    public String getIdCust(){ return idCust;}
    public String getNama(){return nama;}
    public String getNoHp(){return noHp;}

    public void tampilkanProfil(){
        System.out.println("Customer: "+nama+"(ID: "+idCust+", HP: "+noHp+") ");
    }
}