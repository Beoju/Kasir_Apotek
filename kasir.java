import java.util.Scanner;
public class kasir {
    public static void main(String[] args) {
        int jmlObat, harga,total,bayar;
        double diskon;
        String member;
        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan jumlah obat :");
        jmlObat = sc.nextInt();
        System.out.print("Masukkan harga obat :");
        harga = sc.nextInt();
        total = jmlObat*harga;
        System.out.println("total yang harus anda bayar adalah : " + total);
        if (total>200000) {
            System.out.print("Apakah memiliki member? (y/t): ");
            member = sc.next();
            if (member.equalsIgnoreCase("y")){
                diskon = 0.05;
                total -= total * diskon;
                System.out.println("Anda mendapatkan diskon sebesar 5%");
            } else {
                diskon = 0.02;
                total -= total * diskon;
                System.out.println("Anda mendapatkan diskon sebesar 2%");
            }
        } else{
            System.out.println("Maaf, anda tidak mendapatkan diskon.");
        }

       System.out.println("Total yang harus anda bayar: " +total);
    }
}