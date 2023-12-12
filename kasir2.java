import java.util.Scanner;

public class kasir2 {
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

        // Variabel untuk analisis penjualan dan struk
        int totalItemTerjual = 0;
        int totalPenjualan = 0;
        String obatTerjual = "";
        String strukPembelian = "";
        double diskon = 0.0;
        int totalBayar;

        do {
            // Meminta pengguna memilih menu
            System.out.println(
                    "\nPilih menu:\n1. Beli obat\n2. Cek harga obat\n3. Riwayat transaksi\n4. Analisis Penjualan\n5. Selesai");
            System.out.print("Masukkan pilihan Anda (1/2/3/4/5): ");
            int menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1:
                    boolean tambahItem;
                    tambahItem = true;
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
                            break;
                        }

                        System.out.print("Jumlah obat yang dibeli: ");
                        int jumlahObat = scanner.nextInt();

                        int hargaSatuan = hargaObat[nomorObat - 1];
                        int totalHargaObat = hargaSatuan * jumlahObat;
                        strukPembelian += "Obat         : " + daftarObat[nomorObat - 1] + "\n" +
                                          "Jumlah item  : " + jumlahObat + "\n" +
                                          "Total        : Rp" + totalHargaObat + "\n";

                        // Menambahkan informasi pembelian ke riwayatTransaksi
                        riwayatTransaksi[transaksi] = "Obat: " + daftarObat[nomorObat - 1] +
                                ", Jumlah: " + jumlahObat +
                                ", Total Harga: Rp" + (hargaObat[nomorObat - 1] * jumlahObat);
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
                            break;
                        }
                    }
                    break;
                case 2:
                    // Meminta pengguna memasukkan nomor obat untuk cek harga
                    System.out.print("Masukkan nomor obat untuk cek harga: ");
                    int nomorObatCek = scanner.nextInt();

                    // Memeriksa apakah nomor obat valid untuk cek harga
                    if (nomorObatCek < 1 || nomorObatCek > daftarObat.length) {
                        System.out.println("Nomor obat tidak valid.");
                        break;
                    }

                    // Menampilkan harga obat berdasarkan nomor obat yang dipilih
                    System.out.println("Harga " + daftarObat[nomorObatCek - 1] + ": Rp" + hargaObat[nomorObatCek - 1]);
                    break;
                case 3:
                    // Menampilkan riwayat transaksi
                    System.out.println("\nLaporan Transaksi:");
                    for (int i = 0; i < transaksi; i++) {
                        if (riwayatTransaksi[i] != null) {
                            System.out.println("Transaksi ke-" + (i + 1) + ":");
                            System.out.println(riwayatTransaksi[i]);
                            System.out.println("================================");
                        }
                    }
                    break;
                case 4:
                    System.out.println("\nAnalisis Penjualan: ");
                    System.out.println("Obat yang terjual   : " + obatTerjual);
                    System.out.println("Total Item Terjual  : " + totalItemTerjual);
                    System.out.println("Total Penjualan     : Rp" + totalPenjualan);
                case 5:
                    // Keluar dari loop jika pengguna memilih selesai
                    System.out.println("Terima kasih telah menggunakan layanan kami.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
            // Menanyakan apakah pengguna ingin menambah item lagi
            System.out.print("\nApakah Anda ingin kembali ke menu sebelumnya? (y/t): ");
        } while (scanner.next().equalsIgnoreCase("y"));

        // Hitung total pembelian, total bayar, dan kembalian
        int totalPembelian = totalHarga;
        if (totalPembelian > 200000) {
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
        totalBayar = scanner.nextInt();

        // Menampilkan struk
        cetakStrukPembelian(strukPembelian, totalPembelian, diskon, totalBayar);;

        // Menutup Scanner
        scanner.close();
    }

    public static void cetakStrukPembelian(String strukPembelian, int totalPembelian,double diskon, int totalBayar) {
        System.out.println("================================");
        System.out.println("        APOTEK SIB 1C");
        System.out.println("    Jl. Soekarno Hatta No.9");
        System.out.println("================================");
        System.out.println(strukPembelian);
        System.out.println("================================");
        System.out.println("Diskon       :" + (diskon * 100)+ "%" );
        System.out.println("Total bayar  : Rp" + totalBayar);
        System.out.println("Kembalian    : Rp" + (totalBayar - totalPembelian));
        System.out.println("================================");
        System.out.println("            THANK YOU");
        System.out.println("       STAY HEALTHY & HAPPY");
        System.out.println("================================");
    }

}
