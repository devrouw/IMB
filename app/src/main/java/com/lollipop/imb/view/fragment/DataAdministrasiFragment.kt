package com.lollipop.imb.view.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kofigyan.stateprogressbar.StateProgressBar
import com.lollipop.imb.R
import com.lollipop.imb.databinding.FragmentDataAdministrasiBinding
import com.lollipop.imb.view.ui.PengajuanActivity
import com.lollipop.imb.viewModel.MainViewModel

class DataAdministrasiFragment : Fragment() {
    private var _bindingFragment: FragmentDataAdministrasiBinding? = null
    private val _binding get() = _bindingFragment!!

    private lateinit var _viewModel: MainViewModel
    private lateinit var _mContext: Context

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindingFragment = FragmentDataAdministrasiBinding.inflate(inflater,container,false)
        initializeViewModel()
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnPrev = view.rootView.findViewById<FloatingActionButton>(R.id.btn_prev)
        val btnNext = view.rootView.findViewById<FloatingActionButton>(R.id.btn_next)
        btnNext.setImageResource(R.drawable.ic_baseline_check)

        observableLiveData()
    }

    private fun observableLiveData() {

    }

    private fun initializeViewModel() {
        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}