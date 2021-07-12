package com.lollipop.e_lapor.repository

import androidx.lifecycle.MutableLiveData
import com.lollipop.e_lapor.util.ResultOfNetwork
import com.lollipop.imb.service.model.Akun
import com.lollipop.imb.service.model.DataPengajuan
import com.lollipop.imb.service.model.KirimData
import com.lollipop.imb.service.model.LoginData
import com.lollipop.imb.service.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainRepository() {
    val dataResult = MutableLiveData<ResultOfNetwork<KirimData>>()
    val loginResult = MutableLiveData<ResultOfNetwork<LoginData>>()
    val pengajuanResult = MutableLiveData<ResultOfNetwork<KirimData>>()

    suspend fun daftarAkun(case: String, akun: Akun) =
        withContext(Dispatchers.IO){
            dataResult.postValue(ResultOfNetwork.Success(
                RetrofitClient.ftp.daftar(case,akun.no_ktp,akun.nama_lengkap,akun.provinsi,akun.alamat,akun.no_hp,
                    akun.email,akun.password)
            ))
        }

    suspend fun loginAkun(case: String, email: String, password: String) =
        withContext(Dispatchers.IO){
            loginResult.postValue(ResultOfNetwork.Success(
                RetrofitClient.ftp.login(case,email,password)
            ))
        }

    suspend fun pengajuanImb(case: String, idAkun: String, data: DataPengajuan){
        withContext(Dispatchers.IO){
            pengajuanResult.postValue(ResultOfNetwork.Success(
                RetrofitClient.ftp.pengajuan(case, idAkun, "","","","","",
                "","","","","","","","",
                "","","","","","","",
                "","","","","","","",
                "","","","")
            ))
        }
    }

}