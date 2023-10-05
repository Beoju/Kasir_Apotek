import java.util.Scanner;
public class jobsheet3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int jmlBrg;
        double harga, jmlByr, jmlTunai, jmlKembali;
        String namaToko="Apotek SIB1C", tgl, waktu, namaObat;
        System.out.println("Masukkkan jumlah barang Anda");
        jmlBrg = sc.nextInt();
        System.out.println("Masukkan harga");
        harga = sc.nextDouble();
        System.out.println("Masukkan jumlah tunai");
        jmlTunai = sc.nextDouble();
        System.out.println("Masukkan tanggal");
        tgl = sc.next();
        System.out.println("Masukkan waktu");
        waktu = sc.next();
        System.out.println("Masukkan Nama Obat");
        namaObat = sc.next();

        jmlByr = jmlBrg*harga;
        jmlKembali = jmlTunai-jmlByr;
        System.out.println(namaToko);
        System.out.println(tgl);
        System.out.println(waktu);
        System.out.println(namaObat);
        System.out.println("Total: " +jmlByr);
        System.out.println("Tunai: "+jmlTunai);
        System.out.println("Kembali: "+jmlKembali);
        
    
    
    }
}