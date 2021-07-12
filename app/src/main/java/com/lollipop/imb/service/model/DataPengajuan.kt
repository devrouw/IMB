package com.lollipop.imb.service.model

data class DataPengajuan(
    val kepemilikan_nib: String = "",
    val bentuk_kepemilikan: String = "",
    val nama_pemilik: String = "",
    val alamat_pemilik: String = "",
    val no_telp: String = "",
    val email: String = "",
    val no_ktp: String = "-",
    val provinsi: String = "",
    val kota: String = "",
    val kecamatan: String = "",
    val alamat_bangunan: String = "",
    val nama_bangunan: String = "",
    val permohonan_imb: String = "",
    val fungsi_bangunan: String = "-",
    val jenis_bangunan: String = "",
    val tinggi_bangunan: String = "",
    val jumlah_lantai: String = "",
    val luas_basement: String = "",
    val luas_lantai_basement: String = "",
    val dokumen_teknis: String = "",
    val jenis_dokumen: String = "-",
    val tgl_terbit_dokumen: String = "",
    val hak_atas_tanah: String = "",
    val lokasi_tanah: String = "",
    val batas_kepemilikan: String = "",
    val nomor_dokumen: String = "",
    val luas_tanah: String = "",
    val nama_pemegang: String = "-",
    val scan_ktp: String = "",
    val scan_bukti_lunas_pbb: String = "",
    val scan_pehitungan_sondir: String = ""
)
