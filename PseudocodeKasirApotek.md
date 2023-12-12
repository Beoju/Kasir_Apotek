# Pseudocode Kasir Apotek 
MULAI
    DEKLARASI variabel total_harga
    total_harga = 0
    
    TAMPILKAN "Selamat datang di sistem kasir apotek"
    
    LAKUKAN
        TAMPILKAN "Pilih salah satu opsi:"
        TAMPILKAN "1. Tambahkan obat ke keranjang"
        TAMPILKAN "2. Selesai dan bayar"
        TAMPILKAN "3. Keluar"
        
        BACA opsi (1, 2, 3)
        
        JIKA opsi = 1
            TAMPILKAN "Masukkan nama obat:"
            BACA nama_obat
            TAMPILKAN "Masukkan harga obat:"
            BACA harga_obat
            
            TAMPILKAN "Masukkan jumlah obat yang dibeli:"
            BACA jumlah_obat
            
            total_harga = total_harga + (harga_obat * jumlah_obat)
            TAMPILKAN "Obat ", nama_obat, " sejumlah ", jumlah_obat, " buah ditambahkan ke keranjang."
        
        JIKA opsi = 2
            TAMPILKAN "Total harga belanja: ", total_harga
            TAMPILKAN "Masukkan jumlah uang pembayaran:"
            BACA jumlah_pembayaran
            
            JIKA jumlah_pembayaran = total_harga
                kembalian = jumlah_pembayaran - total_harga
                TAMPILKAN "Terima kasih! Transaksi selesai."
                TAMPILKAN "Kembalian Anda: ", kembalian
                BERHENTI
            LAINNYA
                TAMPILKAN "Jumlah uang pembayaran tidak mencukupi. Mohon masukkan jumlah yang cukup."
        
        JIKA opsi = 3
            TAMPILKAN "Terima kasih! Sampai jumpa lagi."
            BERHENTI
        
        LAINNYA
            TAMPILKAN "Opsi tidak valid. Silakan pilih opsi yang benar."
    
    SELAMA opsi != 3
AKHIR

