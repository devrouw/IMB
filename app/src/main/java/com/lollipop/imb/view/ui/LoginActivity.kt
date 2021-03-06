package com.lollipop.imb.view.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.lollipop.e_lapor.util.Constant
import com.lollipop.e_lapor.util.ResultOfNetwork
import com.lollipop.imb.databinding.ActivityLoginBinding
import com.lollipop.imb.service.model.LoginResult
import com.lollipop.imb.viewModel.DataStoreViewModel
import com.lollipop.imb.viewModel.MainViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityLoginBinding

    private lateinit var _viewModelDataStore: DataStoreViewModel
    private lateinit var _viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        initalizeViewModel()

        with(_binding) {
            tvDaftar.setOnClickListener {
                startActivity(Intent(this@LoginActivity, DaftarActivity::class.java))
            }
            btMasuk.setOnClickListener {
                _viewModel.login("login","${etEmail.text}","${etPassword.text}")
            }
        }

        observableLiveData()

    }

    private fun observableLiveData() {
        _viewModel.loginAkun.observe(this@LoginActivity, { result ->
            when (result) {
                is ResultOfNetwork.Success -> {
                    result.value.code?.let { isSuccessNetworkCallback(it, result.value.data) }
                }
                is ResultOfNetwork.Failure -> {
                    Toast.makeText(this@LoginActivity, result.message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initalizeViewModel() {
        _viewModelDataStore = ViewModelProvider(this).get(DataStoreViewModel::class.java)
        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    private fun isSuccessNetworkCallback(code: Int, data: List<LoginResult>?) {
        when (code) {
            Constant.Network.REQUEST_NOT_FOUND -> {
                Toast.makeText(this@LoginActivity, "Email atau Password Salah", Toast.LENGTH_SHORT)
                    .show()
            }
            Constant.Network.REQUEST_SUCCESS -> {
                if (data != null) {
                    data.get(0).no_ktp?.let {
                        data.get(0).email?.let { it1 ->
                            _viewModelDataStore.setAuthPref(
                                it,
                                it1
                            )
                        }
                    }
                }
                _viewModelDataStore.setLoginStatus(true)
                Toast.makeText(this@LoginActivity, "Berhasil Masuk", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}