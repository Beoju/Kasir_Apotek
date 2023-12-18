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
        int totalHarga = 0;

        // Variabel untuk analisis penjualan
        int totalItemTerjual = 0;
        double totalPenjualan= 0;
        String obatTerjual = "";

        do {
            // Meminta pengguna memilih menu
            System.out.println("\nPilih menu:\n1. Kasir\n2. Manajer\n3. Selesai");
            System.out.print("Masukkan pilihan Anda (1/2/3): ");
            int menuChoice = scanner.nextInt();
        
            switch (menuChoice) {
                case 1:
                // Fungsi untuk menu Kasir 
                menuKasir(scanner, daftarObat, hargaObat, riwayatTransaksi);
                break;
                case 2:
                // Fungsi untuk menu Admin
                menuAdmin (riwayatTransaksi, transaksi, totalItemTerjual, totalPenjualan);
                break;
                case 3:
                // Keluar dari loop jika pengguna memilih selesai
                System.out.println("Terima kasih telah menggunakan layanan kami.");
                return;
                default:
                System.out.println("Pilihan tidak valid");
                break;
            }

            // Menanyakan apakah pengguna ingin melanjutkan
            System.out.println("\nApakah Anda ingin melanjutkan? (y/t): ");
        }while (scanner.next().equalsIgnoreCase("y"));
            
        // Menutup Scanner
        scanner.close();
    }

    // Fungsi untuk menu Kasir
    public static void menuKasir(Scanner scanner, String[] daftarObat, int[] hargaObat, String[] riwayatTransaksi, int transaksi, int totalHarga, int totalItemTerjual, double totalPenjualan, String obatTerjual) {
        boolean tambahItem = true;
    
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
           }

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
        
        // Menampilkan tanggal
        System.out.print("Tanggal: ");
        String tanggal = scanner.next();
        System.out.println("===============================");
        // Menampilkan daftar obat untuk pilihan pengguna
System.out.println("Daftar Obat:");
for (int i = 0; i < daftarObat.length; i++) {
    System.out.println((i + 1) + ". " + daftarObat[i] + " - Rp" + hargaObat[i]);
}
do{
// Meminta pengguna memasukkan nomor obat yang akan dibeli
System.out.print("Nomor obat yang dibeli: ");
int nomorObat = scanner.nextInt();

// Memeriksa apakah nomor obat valid
if (nomorObat < 1 || nomorObat > daftarObat.length) {
    System.out.println("Nomor obat tidak valid.");
    return;
}
// Meminta pengguna memasukkan jumlah obat yang dibeli
System.out.print("Jumlah obat yang dibeli: ");
int jumlahObat = scanner.nextInt();

// Fungsi untuk menu Admin
    public static void menuAdmin(String[] riwayatTransaksi, int transaksi, int totalItemTerjual, double totalPenjualan) {
        // Menampilkan riwayat transaksi
        tampilkanLaporan(riwayatTransaksi, transaksi);


// Menampilkan informasi pembelian pada struk
System.out.println("===============================");
System.out.println("Obat: " + daftarObat[nomorObat - 1]);
System.out.println("Jumlah: " + jumlahObat);
System.out.println("Total Harga: Rp" + (hargaObat[nomorObat - 1] * jumlahObat));
System.out.println("------------------------------");

        // Menampilkan obat yang terjual dan jumlahnya
        System.out.println("\nAnalisis Penjualan:");
        System.out.println("Total Item Terjual: " + totalItemTerjual);
        System.out.println("Total Penjualan: Rp" + totalPenjualan);
        System.out.println("Obat yang Terjual:" + obatTerjual);

        // Menampilkan laporan transaksi atau riwayat penjualan
        tampilkanLaporan(riwayatTransaksi, transaksi);

        // Menampilkan total item terjual dan total penjualan
        System.out.println("\nAnalisis Penjualan: ");
        System.out.println("Obat yang terjual: " + obatTerjual);
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
