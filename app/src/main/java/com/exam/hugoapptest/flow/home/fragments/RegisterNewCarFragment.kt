package com.exam.hugoapptest.flow.home.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exam.hugoapptest.base.BaseFragment
import com.exam.hugoapptest.databinding.FragmentNewCarRegisterBinding
import com.exam.hugoapptest.flow.home.viewModel.NewCarRegisterViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class RegisterNewCarFragment : BaseFragment() {

    @Inject
    lateinit var viewModel: NewCarRegisterViewModel

    private lateinit var binding: FragmentNewCarRegisterBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewCarRegisterBinding.inflate(inflater)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initSpinnerListener()
    }

    private fun initSpinnerListener() {
        binding.spinnerCarType.onItemSelectedListener = viewModel.itemSelectedListener
    }
}