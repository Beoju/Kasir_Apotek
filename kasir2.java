import java.util.Scanner;

public class kasir2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar obat dan harga
        String[] daftarObat = {"Paracetamol", "Vitamin C", "Antibiotik", "Obat Flu"};
        double[] hargaObat = {5.0, 10.0, 15.0, 8.0};

        // Menampilkan daftar obat
        System.out.println("Daftar Obat:");
        for (int i = 0; i < daftarObat.length; i++) {
            System.out.println((i + 1) + ". " + daftarObat[i] + " - Rp" + hargaObat[i]);
        }

        // Meminta pengguna memasukkan informasi pembelian
        System.out.println("\nMasukkan informasi pembelian (pisahkan dengan spasi):");
        System.out.print("Nomor obat jumlah_obat: ");
        int nomorObat = scanner.nextInt();
        System.out.println("Masukkan jumlah obat: ");
        int jumlahObat = scanner.nextInt();

        // Memeriksa apakah nomor obat valid
        if (nomorObat < 1 || nomorObat > daftarObat.length) {
            System.out.println("Nomor obat tidak valid.");
            return;
        }

        // Menghitung total harga
        double totalHarga = hargaObat[nomorObat - 1] * jumlahObat;

        // Menampilkan struk pembelian
        System.out.println("\nStruk Pembelian:");
        System.out.println("Obat: " + daftarObat[nomorObat - 1]);
        System.out.println("Harga per unit: Rp" + hargaObat[nomorObat - 1]);
        System.out.println("Jumlah obat: " + jumlahObat);
        System.out.println("Total Harga: Rp" + totalHarga);
        
        // Menutup Scanner
        scanner.close();
    }
}
