package com.lollipop.imb.service.network

import com.lollipop.imb.service.model.Akun
import com.lollipop.imb.service.model.KirimData
import com.lollipop.imb.service.model.LoginData
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ShaNetwork {
    @FormUrlEncoded
    @POST("api.php")
    suspend fun daftar(
        @Field("case") case : String,
        @Field("no_ktp") noKtp : String,
        @Field("nama_lengkap") namaLengkap : String,
        @Field("provinsi") provinsi : String,
        @Field("alamat") alamat : String,
        @Field("no_hp") noHp : String,
        @Field("email") email : String,
        @Field("password") password : String
    ) : KirimData

    @FormUrlEncoded
    @POST("api.php")
    suspend fun login(
        @Field("case") case : String,
        @Field("email") email : String,
        @Field("password") password : String
    ) : LoginData

    @FormUrlEncoded
    @POST("api.php")
    suspend fun pengajuan(
        @Field("case") case : String,
        @Field("kepemilikan_nib") kepemilikan_nib : String,
        @Field("bentuk_kepemilikan") bentuk_kepemilikan : String,
        @Field("nama_pemilik") nama_pemilik : String,
        @Field("alamat_pemilik") alamat_pemilik : String,
        @Field("no_telp") no_telp : String,
        @Field("email") email : String,
        @Field("no_ktp") no_ktp : String,
        @Field("provinsi") provinsi : String,
        @Field("kota") kota : String,
        @Field("kecamatan") kecamatan : String,
        @Field("alamat_bangunan") alamat_bangunan : String,
        @Field("nama_bangunan") nama_bangunan : String,
        @Field("permohonan_imb") permohonan_imb : String,
        @Field("fungsi_bangunan") fungsi_bangunan : String,
        @Field("jenis_bangunan") jenis_bangunan : String,
        @Field("tinggi_bangunan") tinggi_bangunan : String,
        @Field("jumlah_lantai") jumlah_lantai : String,
        @Field("luas_basement") luas_basement : String,
        @Field("luas_lantai_basement") luas_lantai_basement : String,
        @Field("dokumen_teknis") dokumen_teknis : String,
        @Field("jenis_dokumen") jenis_dokumen : String,
        @Field("tgl_terbit_dokumen") tgl_terbit_dokumen : String,
        @Field("hak_atas_tanah") hak_atas_tanah : String,
        @Field("lokasi_tanah") lokasi_tanah : String,
        @Field("batas_kepemilikan") batas_kepemilikan : String,
        @Field("nomor_dokumen") nomor_dokumen : String,
        @Field("luas_tanah") luas_tanah : String,
        @Field("nama_pemegang") nama_pemegang : String,
        @Field("scan_ktp") scan_ktp : String,
        @Field("scan_bukti_lunas_pbb") scan_bukti_lunas_pbb : String,
        @Field("scan_pehitungan_sondir") scan_pehitungan_sondir : String,
        @Field("id_akun") id_akun : String
    ) : KirimData
}