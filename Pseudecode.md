Algoritma : Kasir_Apotek
Deklarasi
jmlBrg,harga, jmlBayar, jmlTunai, jmlKembali : int
namaToko= Apotek SIB1C, tgl, waktu, namaObat : string
Deskripsi :
print "Masukkkan jumlah barang Anda"
read jmlBrg
print "Masukkan harga"
read harga
print "Masukkan jumlah tunai"
read jmlTunai
print "Masukkan tanggal"
read tgl
print "Masukkan waktu"
read waktu
print "Masukkan Nama Obat"
read namaObat
jmlBayar = jmlBrg*harga
jmlKembali = jmlTunai-jmlBayar
print namaToko
print tgl
print waktu
print namaObat
print "Total:" 
print jmlBayar
print "Tunai:" 
print jmlTunai
print "Kembali:" 
print jmlKembali
