import java.util.Scanner;

public class kasir2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar obat dan harga
        String[] daftarObat = {"Paracetamol", "Vitamin C", "Antibiotik", "Obat Flu"};
        int[] hargaObat = {5000, 10000, 15000, 8000};

        // Menampilkan daftar obat
        System.out.println("Daftar Obat:");
        for (int i = 0; i < daftarObat.length; i++) {
            System.out.println((i + 1) + ". " + daftarObat[i] + " - Rp" + hargaObat[i]);
        }

        // Meminta pengguna memasukkan informasi pembelian
        System.out.println("\nMasukkan informasi pembelian");
        System.out.print("Nomor obat yang dibeli: ");
        int nomorObat = scanner.nextInt();

        // Memeriksa apakah nomor obat valid
        if (nomorObat < 1 || nomorObat > daftarObat.length) {
            System.out.println("Nomor obat tidak valid.");
            return;
        }

        System.out.print("Jumlah obat yang dibeli: ");
        int jumlahObat = scanner.nextInt();

        // Menghitung total harga obat yang dibeli
        int totalHarga = hargaObat[nomorObat - 1] * jumlahObat;

        // Menampilkan total harga obat yang dibeli
        System.out.println("\nTotal harga obat yang dibeli: Rp" + totalHarga);

        // Memeriksa apakah pengguna berhak mendapatkan diskon
        double diskon = 0;
        if (totalHarga > 200000) {
            System.out.print("Apakah Anda memiliki member? (y/t): ");
            String member = scanner.next();
            if (member.equalsIgnoreCase("y")) {
                diskon = 0.05;
                totalHarga -= totalHarga * diskon;
                System.out.println("Anda mendapatkan diskon sebesar 5%");
            } else {
                diskon = 0.02;
                totalHarga -= totalHarga * diskon;
                System.out.println("Anda mendapatkan diskon sebesar 2%");
            }
        } else {
            System.out.println("Maaf, Anda tidak mendapatkan diskon.");
        }

        // Menampilkan total harga yang harus dibayar setelah diskon
        System.out.println("Total yang harus Anda bayar: Rp" + totalHarga);

        // Menampilkan struk pembelian
        System.out.println("\nStruk Pembelian:");
        System.out.println("                APOTEK SIB 1C");
        System.out.println("           Jl. Soekarno Hatta No.9");
        System.out.println("=============================================");
        System.out.println("Obat: " + daftarObat[nomorObat - 1]);
        System.out.println("Harga per item: Rp" + hargaObat[nomorObat - 1]);
        System.out.println(jumlahObat + "item");
        System.out.println("=============================================");
        System.out.println("Diskon: " + (diskon * 100) + "%");
        System.out.println("Total Harga: Rp" + totalHarga);
        System.out.println("=============================================");
        System.out.println("         BARANG YANG SUDAH DI BELI");
        System.out.println("         TIDAK DAPAT DIKEMBALIKAN");
        System.out.println("              TERIMA KASIH");

        // Menutup Scanner
        scanner.close();
    }
}
