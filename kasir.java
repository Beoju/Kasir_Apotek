import java.util.Scanner;
public class kasir {
    public static void main(String[] args) {
        int jmlObat, harga,total,bayar;
        double diskon;
        String member,namaObat;
        Scanner sc = new Scanner(System.in);
        System.out.println("SELAMAT DATANG DI APOTEK SIB 1C");
        System.out.println("Masukkan nama obat :");
        namaObat = sc.nextLine();
        System.out.println("Masukkan jumlah obat :");
        jmlObat = sc.nextInt();
        System.out.println("Masukkan harga obat :");
        harga = sc.nextInt();
        total = jmlObat*harga;
        System.out.println("total yang harus anda bayar adalah : " + total);
        if (total>200000) {
        }
        do {
            System.out.print("Apakah memiliki member? (y/t)");
            member = sc.nextLine();
    
        } while (total<=200000);
        System.out.println("Maaf anda tidak mendapatkan diskon");

    }
}
