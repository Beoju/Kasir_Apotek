import java.util.Scanner;

public class kasir2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar obat dan harga
        String[] daftarObat = {"Paracetamol", "Vitamin C", "Antibiotik", "Obat Flu"};
        int[] hargaObat = {5000, 10000, 15000, 8000};

        // Riwayat transaksi
        String[] riwayatTransaksi = new String[20]; // Misalnya, menyimpan 10 transaksi terakhir
        int transaksi = 0;

        // Variabel totalHarga perlu diinisialisasi di luar loop
        double totalHarga = 0;

        // Variabel untuk analisis penjualan
        int totalItemTerjual = 0;
        double totalPenjualan= 0;

        // Variabel untuk menyimpan obat yang terjual
        String obatTerjual = new String();

        do {
            // Menampilkan daftar obat
            System.out.println("Daftar Obat:");
            for (int i = 0; i < daftarObat.length; i++) {
                System.out.println((i + 1) + ". " + daftarObat[i] + " - Rp" + hargaObat[i]);
            }

            // Meminta pengguna memasukkan informasi pembelian
            System.out.println("\nMasukkan informasi pembelian (nomor_obat jumlah_obat):");
            System.out.print("Nomor obat yang dibeli: ");
            int nomorObat = scanner.nextInt();

            // Memeriksa apakah nomor obat valid
            if (nomorObat < 1 || nomorObat > daftarObat.length) {
                System.out.println("Nomor obat tidak valid.");
                return;
            }

            System.out.print("Jumlah obat yang dibeli: ");
            int jumlahObat = scanner.nextInt();

            // Menambahkan informasi pembelian ke riwayatTransaksi
            riwayatTransaksi[transaksi] = "Obat: " + daftarObat[nomorObat - 1] +
                    ", Jumlah: " + jumlahObat +
                    ", Total Harga: Rp" + (hargaObat[nomorObat - 1] * jumlahObat);
            transaksi++;

            // Menambahkan totalHarga berdasarkan informasi pembelian
            totalHarga += hargaObat[nomorObat - 1] * jumlahObat;
            
            //Menambahkan totalItemTerjual dan totalPenjualan
            totalItemTerjual += jumlahObat;
            totalPenjualan += hargaObat[nomorObat - 1] * jumlahObat;

            // Menambahkan obat ke daftar obat yang terjual
            obatTerjual += daftarObat[nomorObat - 1] + ", ";


            // Menanyakan apakah pengguna ingin menambah item lagi
            System.out.print("\nApakah Anda ingin menambah item lagi? (y/t): ");
        } while (scanner.next().equalsIgnoreCase("y"));

        // Memeriksa apakah pengguna berhak mendapatkan diskon
        double diskon = 0.0;

        if (totalHarga > 200000) {
            System.out.print("Apakah Anda memiliki member? (y/t): ");
            String member = scanner.next();

            if (member.equalsIgnoreCase("y")) {
                diskon = 0.05;
                System.out.println("Anda mendapatkan diskon sebesar 5%");
            } else {
                diskon = 0.02;
                System.out.println("Anda mendapatkan diskon sebesar 2%");
            }

            totalHarga -= totalHarga * diskon;
        } else {
            System.out.println("Maaf, Anda tidak mendapatkan diskon.");
        }

        // Menampilkan total harga yang harus dibayar setelah diskon
        System.out.println("Total yang harus Anda bayar: Rp" + totalHarga);

        // Menampilkan struk pembelian
        System.out.println("\nStruk Pembelian Apotek SIB 1C");
    
        for (int i = 0; i < transaksi; i++) {
            System.out.println("Daftar pembelian:" );

        // Menampilkan obat yang terjual dan jumlahnya
        System.out.println("\nAnalisis Penjualan:");
        System.out.println("Total Item Terjual: " + totalItemTerjual);
        System.out.println("Total Penjualan: Rp" + totalPenjualan);
        System.out.println("Obat yang Terjual:");

        // Menampilkan laporan transaksi atau riwayat penjualan
        tampilkanLaporan(riwayatTransaksi, transaksi);

        // Menampilkan total item terjual dan total penjualan
        System.out.println("\nAnalisis Penjualan: ");
        System.out.println("Obat yang terjual: " + daftarObat);
        System.out.println("Total Item Terjual: " + totalItemTerjual);
        System.out.println("Total Penjualan: Rp" + totalPenjualan );


        // Menutup Scanner
        scanner.close();
    }

    // Fungsi untuk menampilkan laporan riwayat transaksi
    public static void tampilkanLaporan(String[] riwayatTransaksi, int jumlahTransaksi) {
        System.out.println("\nLaporan Transaksi:");

        for (int i = 0; i < jumlahTransaksi; i++) {
            System.out.println("Transaksi ke-" + (i + 1) + ": " + riwayatTransaksi[i]);
        }
    }
}
