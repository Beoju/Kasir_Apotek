import java.util.Scanner;

public class kasir2 {
    public static int totalItemTerjual = 0;
    public static int totalPenjualan = 0;
    public static String obatTerjual = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar obat dan harga
        String[] daftarObat = { "Paracetamol", "Vitamin C", "Antibiotik", "Obat Flu" };
        int[] hargaObat = { 5000, 10000, 15000, 8000 };

        // Riwayat transaksi
        String[] riwayatTransaksi = new String[20]; // Misalnya, menyimpan 10 transaksi terakhir
        int transaksi = 0;

        // Variabel totalHarga perlu diinisialisasi di luar loop
        int totalHarga = 0;
        double diskon = 0.0;

        do {
            // Meminta pengguna memilih menu
            System.out.println("\nPilih menu:\n1. Kasir\n2. Manajer\n3. Selesai");
            System.out.print("Masukkan pilihan Anda (1/2/3): ");
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    menuKasir(scanner, daftarObat, hargaObat, riwayatTransaksi, transaksi);
                    break;
                case 2:
                    menuManajer(riwayatTransaksi, transaksi);
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }

            System.out.print("\nApakah Anda ingin melanjutkan? (y/t): ");
        } while (scanner.next().equalsIgnoreCase("y"));

        scanner.close();
    }

    public static void menuKasir(Scanner scanner, String[] daftarObat, int[] hargaObat, String[] riwayatTransaksi,
            int transaksi) {
        boolean tambahItem = true;

        while (tambahItem) {
            System.out.println("\nPilih menu Kasir:\n1. Beli Obat\n2. Cek Harga Obat");
            System.out.print("Masukkan pilihan Anda (1/2): ");
            int kasirChoice = scanner.nextInt();

            switch (kasirChoice) {
                case 1:
                    beliObat(scanner, daftarObat, hargaObat, riwayatTransaksi, transaksi, transaksi, kasirChoice);
                    break;
                case 2:
                    cekHargaObat(scanner, daftarObat, hargaObat);
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
            System.out.print("\nApakah Anda ingin melanjutkan ke menu Kasir? (y/t): ");
            tambahItem = scanner.next().equalsIgnoreCase("y");
        }
    }

    public static void beliObat(Scanner scanner, String[] daftarObat, int[] hargaObat, String[] riwayatTransaksi,
        int transaksi, int totalHarga, double diskon) {
        boolean tambahItem = true;
        int totalHargaPerTransaksi = 0;

        while (tambahItem) {
            // Menampilkan daftar obat
            System.out.println("Daftar Obat:");
            for (int i = 0; i < daftarObat.length; i++) {
                System.out.println((i + 1) + ". " + daftarObat[i] + " - Rp" + hargaObat[i]);
            }

            // Meminta pengguna memasukkan nomor obat yang akan dibeli
            System.out.print("Nomor obat yang dibeli: ");
            int nomorObat = scanner.nextInt();

            // Memeriksa apakah nomor obat valid
            if (nomorObat < 1 || nomorObat > daftarObat.length) {
                System.out.println("Nomor obat tidak valid.");
                continue;
            }

            System.out.print("Jumlah obat yang dibeli: ");
            int jumlahObat = scanner.nextInt();

            int hargaSatuan = hargaObat[nomorObat - 1];
            int totalHargaObat = hargaSatuan * jumlahObat;

            // Menambahkan informasi pembelian ke riwayatTransaksi
            riwayatTransaksi[transaksi] = "Obat: " + daftarObat[nomorObat - 1] +
                    ", Jumlah: " + jumlahObat +
                    ", Total Harga: Rp" + totalHargaObat;
            transaksi++;

            // Menyimpan informasi obat yang terjual
            if (!obatTerjual.equals("")) {
                obatTerjual += ", ";
            }
            obatTerjual += daftarObat[nomorObat - 1];

            // Menambahkan totalHarga berdasarkan informasi pembelian
            totalHarga += hargaObat[nomorObat - 1] * jumlahObat;

            // Menambah total item terjual dan total penjualan
            totalItemTerjual += jumlahObat;
            totalPenjualan += hargaObat[nomorObat - 1] * jumlahObat;

            // Menanyakan apakah pengguna ingin menambah item lagi
            System.out.print("\nApakah Anda ingin menambah item lagi? (y/t): ");
            String jawaban = scanner.next();
            if (!jawaban.equalsIgnoreCase("y")) {
                tambahItem = false;
            }
        }

        // Hitung total pembelian, total bayar, dan kembalian
        int totalPembelian = totalHarga;
        if (totalPembelian > 50000) {
            System.out.print("Apakah Anda memiliki member? (y/t): ");
            String member = scanner.next();

            if (member.equalsIgnoreCase("y")) {
                diskon = 0.05;
                System.out.println("Anda mendapatkan diskon sebesar 5%");
            } else {
                diskon = 0.02;
                System.out.println("Anda mendapatkan diskon sebesar 2%");
            }

            totalPembelian -= totalPembelian * diskon;
        } else {
            System.out.println("Maaf, Anda tidak mendapatkan diskon.");
        }

        System.out.println("Total pembelian: Rp" + totalPembelian);
        System.out.print("Total bayar: Rp");
        int totalBayar = scanner.nextInt();

        // Cetak struk pembelian setelah selesai pembelian obat
        cetakStrukPembelian(obatTerjual, totalBayar, totalHargaPerTransaksi);
    }

    public static void menuManajer(String[] riwayatTransaksi, int transaksi) {
        Scanner scanner = new Scanner(System.in);
        boolean kembaliKeMenuSebelumnya = true;

        do {
            System.out.println("\nPilih menu Manajer:\n1. Riwayat Transaksi\n2. Analisis Laporan Keuangan");
            System.out.print("Masukkan pilihan anda (1/2): ");
            int manajerChoice = scanner.nextInt();

            switch (manajerChoice) {
                case 1:
                    tampilkanRiwayatTransaksi(riwayatTransaksi, transaksi);
                    break;
                case 2:
                    analisisLaporanKeuangan(totalPenjualan);
                    break;
                case 3:
                    kembaliKeMenuSebelumnya = false;
                default:
                    System.out.println("Pilihan tidak valid");
                    break;
            }
            // Menanyakan apakah pengguna ingin kembali ke menu sebelumnya
            if (kembaliKeMenuSebelumnya) {
                System.out.print("\nApakah Anda ingin kembali ke menu Manajer? (y/t): ");
                kembaliKeMenuSebelumnya = scanner.next().equalsIgnoreCase("y");
            }
        } while (kembaliKeMenuSebelumnya);

    }

    public static void cekHargaObat(Scanner scanner, String[] daftarObat, int[] hargaObat) {
        // Meminta pengguna memasukkan nomor obat untuk cek harga
        System.out.print("Masukkan nomor obat untuk cek harga: ");
        int nomorObatCek = scanner.nextInt();

        // Memeriksa apakah nomor obat valid untuk cek harga
        if (nomorObatCek < 1 || nomorObatCek > daftarObat.length) {
            System.out.println("Nomor obat tidak valid.");
            return;
        }

        // Menampilkan harga obat berdasarkan nomor obat yang dipilih
        System.out.println("Harga " + daftarObat[nomorObatCek - 1] + ": Rp" + hargaObat[nomorObatCek - 1]);
    }

    public static void cetakStrukPembelian(String obat, int jumlahObat, int totalHargaObat) {
        System.out.println("================================");
        System.out.println("        APOTEK SIB 1C");
        System.out.println("    Jl. Soekarno Hatta No.9");
        System.out.println("================================");
        System.out.println("Obat: " + obat);
        System.out.println("Jumlah: " + jumlahObat);
        System.out.println("Total Harga: Rp" + totalHargaObat);
        System.out.println("================================");
        System.out.println("            THANK YOU");
        System.out.println("       STAY HEALTHY & HAPPY");
        System.out.println("================================");
    }

    public static void analisisLaporanKeuangan(int totalPenjualan) {
        System.out.println("\nAnalisis Penjualan: ");
        System.out.println("Obat yang terjual   : " + obatTerjual);
        System.out.println("Total Item Terjual  : " + totalItemTerjual);
        System.out.println("Total Penjualan     : Rp" + totalPenjualan);
    }

    public static void tampilkanRiwayatTransaksi(String[] riwayatTransaksi, int transaksi) {
        System.out.println("\nLaporan Transaksi:");
        for (int i = 0; i < transaksi; i++) {
            if (riwayatTransaksi[i] != null) {
                System.out.println("Transaksi ke-" + (i + 1) + ":");
                System.out.println(riwayatTransaksi[i]);
                System.out.println("================================");
            }
        }
    }
    // Metode untuk mencetak laporan bulanan
    public static void cetakLaporanBulanan(int[] penjualanBulanan) {
        System.out.println("\nLaporan Bulanan:");
        for (int i = 0; i < penjualanBulanan.length; i++) {
            if (penjualanBulanan[i] > 0) {
                System.out.println("Bulan " + (i + 1) + ": Rp" + penjualanBulanan[i]);
            }
        }
    }
}
