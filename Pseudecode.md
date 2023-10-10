Algoritma : Kasir_Apotek
Deklarasi
jmlBrg : int
harga, jmlBayar, jmlTunai, jmlKembali : double
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
jmlByr = jmlBrg*harga
jmlKembali = jmlTunai-jmlByr
print namaToko
print tgl
print waktu
print namaObat
print "Total:" 
print jmlByr
print "Tunai:" 
print jmlTunai
print "Kembali:" 
print jmlKembali