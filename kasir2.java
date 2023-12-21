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
        // Stok obat
        int[] stokObat = { 50, 30, 20, 40 }; // Misalnya, stok awal

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
                    menuKasir(scanner, daftarObat, hargaObat, riwayatTransaksi, transaksi, stokObat);
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

    // Fungsi untuk menampilkan daftar obat beserta harganya dan memungkinkan
    // penambahan obat baru
    public static void lihatDaftarObat(Scanner scanner, String[] daftarObat, int[] hargaObat) {
        System.out.println("\nDaftar Obat dan Harga:");
        for (int i = 0; i < daftarObat.length; i++) {
            System.out.println((i + 1) + ". " + daftarObat[i] + " - Rp" + hargaObat[i]);
        }

        System.out.print("\nApakah Anda ingin menambahkan obat baru? (y/t): ");
        String tambahObatBaru = scanner.next();

        if (tambahObatBaru.equalsIgnoreCase("y")) {
            System.out.print("Masukkan nama obat baru: ");
            scanner.nextLine();
            String namaObatBaru = scanner.nextLine();

            System.out.print("Masukkan harga obat baru: ");
            int hargaObatBaru = scanner.nextInt();

            tambahObatBaru(daftarObat, hargaObat, namaObatBaru, hargaObatBaru);
            System.out.println("Obat baru berhasil ditambahkan!");

            System.out.println("\nDaftar Obat dan Harga (Termasuk Obat Baru):");
            for (int i = 0; i < daftarObat.length; i++) {
                System.out.println((i + 1) + ". " + daftarObat[i] + " - Rp" + hargaObat[i]);
            }
        }
    }

    // Fungsi untuk menambah obat baru ke daftar obat dan harga
    public static void tambahObatBaru(String[] daftarObat, int[] hargaObat, String namaObatBaru, int hargaObatBaru) {
        String[] tempDaftarObat = new String[daftarObat.length + 1];
        int[] tempHargaObat = new int[hargaObat.length + 1];

        for (int i = 0; i < daftarObat.length; i++) {
            tempDaftarObat[i] = daftarObat[i];
            tempHargaObat[i] = hargaObat[i];
        }

        tempDaftarObat[daftarObat.length] = namaObatBaru;
        tempHargaObat[hargaObat.length] = hargaObatBaru;

        daftarObat = tempDaftarObat;
        hargaObat = tempHargaObat;
    }

    public static void menuKasir(Scanner scanner, String[] daftarObat, int[] hargaObat, String[] riwayatTransaksi,
            int transaksi, int[] stokObat) {
        boolean tambahItem = true;

        while (tambahItem) {
            System.out
                    .println("\nPilih menu Kasir:\n1. Beli Obat\n2. Cek Harga Obat\n3. Cek Stok Obat\n4. Daftar Obat");
            System.out.print("Masukkan pilihan Anda (1/2/3): ");
            int kasirChoice = scanner.nextInt();

            switch (kasirChoice) {
                case 1:
                    beliObat(scanner, daftarObat, hargaObat, riwayatTransaksi, transaksi, transaksi, kasirChoice,
                            stokObat);
                    break;
                case 2:
                    cekHargaObat(scanner, daftarObat, hargaObat);
                    break;
                case 3:
                    cekStokObat(daftarObat, stokObat, kasirChoice);
                case 4:
                    lihatDaftarObat(scanner, daftarObat, hargaObat);
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
            int transaksi, int totalHarga, double diskon, int[] stokObat) {
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

            // Memasukkan jumlah obat yang dibeli
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

            // Memeriksa apakah stok mencukupi
            if (jumlahObat > stokObat[nomorObat - 1]) {
                System.out.println("Maaf, stok obat tidak mencukupi.");
                return;
            }
            // Update stok setelah pembelian
            stokObat[nomorObat - 1] -= jumlahObat;

            // Menanyakan apakah pengguna ingin menambah item lagi
            System.out.print("\nApakah Anda ingin menambah item lagi? (y/t): ");
            String jawaban = scanner.next();
            if (!jawaban.equalsIgnoreCase("y")) {
                tambahItem = false;
            }

        }

        // Hitung total pembelian, total bayar, dan kembalian
        int totalPembelian = totalHarga;
        System.out.print("Masukkan diskon (dalam persen): ");
        double discon = scanner.nextDouble();

        if (diskon > 0) {
            System.out.println("Anda mendapatkan diskon sebesar " + discon + "%");
            totalPembelian -= totalPembelian * (discon / 100);
        } else {
            System.out.println("Maaf, diskon tidak valid.");
        }

        System.out.print("Pilih jenis pembayaran:\n1. Tunai\n2. Non-Tunai\nMasukkan pilihan Anda (1/2): ");
        int jenisPembayaran = scanner.nextInt();

        switch (jenisPembayaran) {
            case 1:
                // Tambahkan totalPembelian sebagai parameter
                pembayaran(scanner, 1, totalPembelian, totalHargaPerTransaksi);
                break;
            case 2:
                // Tambahkan totalPembelian sebagai parameter
                pembayaran(scanner, 2, totalPembelian, totalHargaPerTransaksi);
                break;
            default:
                System.out.println("Pilihan tidak valid. Mohon pilih 1 untuk tunai atau 2 untuk non-tunai.");
                break;
        }
}

    // fungsi pembayaran
    public static void pembayaran(Scanner scanner, int jenisPembayaran, int totalPembelian, int totalHarga) {
        System.out.println("Anda telah memilih pembayaran " + (jenisPembayaran == 1 ? "tunai" : "non-tunai"));
        System.out.println("Total Pembelian: Rp" + totalPembelian);

        if (jenisPembayaran == 1) {
            System.out.print("Total bayar: Rp");
            int totalBayar = scanner.nextInt();

            if (totalBayar < totalPembelian) {
                System.out.println("Pembayaran kurang. Mohon masukkan jumlah uang yang mencukupi.");
            } else {
                int kembalian = totalBayar - totalPembelian;
                System.out.println("Kembalian: Rp" + kembalian);
                cetakStrukPembelian(obatTerjual, totalHarga, totalPembelian, totalBayar);
            }
        } else if (jenisPembayaran == 2) {
            // Logika untuk pembayaran non-tunai
            System.out.println("Shopeepay");
            // Tambahkan logika sesuai kebutuhan aplikasi untuk pembayaran non-tunai
            cetakStrukPembelian(obatTerjual, totalHarga, totalPembelian, 0); // Untuk pembayaran non-tunai
        }
    }

    // fungsi cek harga obat
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

    public static void cekStokObat(String[] daftarObat, int[] stokObat, int jumlahObat) {
        System.out.println("\nStok Obat yang Tersedia:");
        for (int i = 0; i < daftarObat.length; i++) {
            System.out.println(daftarObat[i] + ": " + stokObat[i]);
        }
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

    public static void cetakStrukPembelian(String obat, int jumlahObat, int totalPembelian, int totalBayar) {
        System.out.println("================================");
        System.out.println("        APOTEK SIB 1C");
        System.out.println("    Jl. Soekarno Hatta No.9");
        System.out.println("================================");
        System.out.println("Obat: " + obat);
        System.out.println("Jumlah: " + jumlahObat);
        System.out.println("Total Harga: " + totalPembelian);
        System.out.println("Total Bayar: Rp" + totalBayar);
        System.out.println("Total Kembalian: " + (totalBayar - totalPembelian));
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
}
