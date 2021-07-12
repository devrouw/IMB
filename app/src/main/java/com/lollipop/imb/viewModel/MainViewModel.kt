package com.lollipop.imb.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lollipop.e_lapor.repository.MainRepository
import com.lollipop.e_lapor.util.ResultOfNetwork
import com.lollipop.imb.service.model.Akun
import com.lollipop.imb.service.model.KirimData
import com.lollipop.imb.service.model.LoginData
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class MainViewModel : ViewModel() {
    private val _repository = MainRepository()

    val daftarAkun: LiveData<ResultOfNetwork<KirimData>>
    val loginAkun: LiveData<ResultOfNetwork<LoginData>>

    init {
        this.daftarAkun = _repository.dataResult
        this.loginAkun = _repository.loginResult
    }

    fun daftar(case: String, akun: Akun){
        viewModelScope.launch {
            try {
                _repository.daftarAkun(case, akun)
            }catch (throwable: Throwable){
                when (throwable) {
                    is IOException -> _repository.dataResult
                        .postValue(
                            ResultOfNetwork.Failure(
                                "[IO] error ${throwable.message} please retry",
                                throwable
                            )
                        )
                    is HttpException -> {
                        _repository.dataResult
                            .postValue(
                                ResultOfNetwork.Failure(
                                    "[HTTP] error ${throwable.message} please retry",
                                    throwable
                                )
                            )
                    }
                    else -> _repository.dataResult
                        .postValue(ResultOfNetwork.Failure("[Unknown] error ${throwable.message} please retry", throwable))
                }
            }
        }
    }

    fun login(case: String, email: String, password: String){
        viewModelScope.launch {
            try {
                _repository.loginAkun(case, email, password)
            }catch (throwable: Throwable){
                when (throwable) {
                    is IOException -> _repository.loginResult
                        .postValue(
                            ResultOfNetwork.Failure(
                                "[IO] error ${throwable.message} please retry",
                                throwable
                            )
                        )
                    is HttpException -> {
                        _repository.loginResult
                            .postValue(
                                ResultOfNetwork.Failure(
                                    "[HTTP] error ${throwable.message} please retry",
                                    throwable
                                )
                            )
                    }
                    else -> _repository.loginResult
                        .postValue(ResultOfNetwork.Failure("[Unknown] error ${throwable.message} please retry", throwable))
                }
            }
        }
    }
}