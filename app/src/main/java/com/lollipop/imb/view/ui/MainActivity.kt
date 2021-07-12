package com.lollipop.imb.view.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.lollipop.imb.databinding.ActivityMainBinding
import com.lollipop.imb.viewModel.DataStoreViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    private lateinit var _viewModelDataStore: DataStoreViewModel
    private var _status = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        initializeViewModel()

        with(_binding){
            btInfo.setOnClickListener {
                startActivity(Intent(this@MainActivity,InfoSyaratActivity::class.java))
            }
            btMasukKeluar.setOnClickListener {
                when(_status){
                    true -> {
                        Toast.makeText(this@MainActivity,"Anda akan keluar",Toast.LENGTH_LONG).show()
                    }
                    false -> {
                        startActivity(Intent(this@MainActivity,LoginActivity::class.java))
                    }
                }
            }
            btPengajuan.setOnClickListener {
                when(_status){
                    true -> {
                        startActivity(Intent(this@MainActivity,PengajuanActivity::class.java))
                    }
                    false -> {
                        startActivity(Intent(this@MainActivity,LoginActivity::class.java))
                    }
                }
            }
        }

        observeDataStore()
    }

    private fun observeDataStore() {
        _viewModelDataStore.loginStatus.observe(this, {
            _status = it
            if(!it){
                _binding.btMasukKeluar.text = "Masuk"
            }else{
                _binding.btMasukKeluar.text = "Keluar"
            }
        })
    }

    private fun initializeViewModel() {
        _viewModelDataStore = ViewModelProvider(this).get(DataStoreViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        observeDataStore()
    }


}