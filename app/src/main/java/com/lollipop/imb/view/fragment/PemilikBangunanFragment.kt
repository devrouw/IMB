package com.lollipop.imb.view.fragment

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kofigyan.stateprogressbar.StateProgressBar
import com.lollipop.imb.R
import com.lollipop.imb.databinding.FragmentPemilikBangunanBinding
import com.lollipop.imb.view.ui.MainActivity
import com.lollipop.imb.view.ui.PengajuanActivity
import com.lollipop.imb.viewModel.MainViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@FlowPreview
@ExperimentalCoroutinesApi
@RequiresApi(Build.VERSION_CODES.M)
class PemilikBangunanFragment : Fragment() {
    private var _bindingFragment: FragmentPemilikBangunanBinding? = null
    private val _binding get() = _bindingFragment!!

    private lateinit var _viewModel: MainViewModel
    private lateinit var _mContext: Context

    private val _lokasiBangunan = LokasiBangunanFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindingFragment = FragmentPemilikBangunanBinding.inflate(inflater,container,false)
        initializeViewModel()
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnPrev = view.rootView.findViewById<FloatingActionButton>(R.id.btn_prev)
        val btnNext = view.rootView.findViewById<FloatingActionButton>(R.id.btn_next)
        btnPrev.visibility = View.GONE

        btnNext.setOnClickListener {
            (activity as PengajuanActivity).nextFragment(StateProgressBar.StateNumber.TWO)
            (activity as PengajuanActivity).replaceFragment(_lokasiBangunan)
        }

        observableLiveData()
    }

    private fun observableLiveData() {

    }

    private fun initializeViewModel() {
        _viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }
}