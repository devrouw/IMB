package com.lollipop.imb.view.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kofigyan.stateprogressbar.StateProgressBar
import com.lollipop.imb.R
import com.lollipop.imb.databinding.ActivityPengajuanImbBinding
import com.lollipop.imb.view.fragment.PemilikBangunanFragment
import com.lollipop.imb.viewModel.MainViewModel

@RequiresApi(Build.VERSION_CODES.M)
class PengajuanActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityPengajuanImbBinding

    private lateinit var _viewModel: MainViewModel
    private val _pemilikBangunanFragment = PemilikBangunanFragment()
    val stepTitle = arrayOf("Pemilik", "Lokasi", "Jenis", "Tanah", "Administrasi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPengajuanImbBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        with(_binding){
            pbState.setStateDescriptionData(stepTitle)
            replaceFragment(_pemilikBangunanFragment)
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container_frame, fragment)
        transaction.commit()
    }

    fun nextFragment(number: StateProgressBar.StateNumber){
        _binding.pbState.setCurrentStateNumber(number)
    }

    private fun hidePrevButton(){
        _binding.btnPrev.visibility = View.GONE
    }

    private fun showPrevButton(){
        _binding.btnPrev.visibility = View.VISIBLE
    }

    private fun changeButton(){
        _binding.btnNext.setImageResource(R.drawable.ic_baseline_check)
    }

}