package com.exam.hugoapptest.flow.home.fragmentsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exam.hugoapptest.base.BaseBottomSheet
import com.exam.hugoapptest.databinding.FragmentSheetRegisterNewAccesBinding
import com.exam.hugoapptest.flow.home.viewModel.HomeRegisterViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class RegisterNewAccessFragmentSheet: BaseBottomSheet() {

    @Inject
    lateinit var viewModel: HomeRegisterViewModel

    private lateinit var binding: FragmentSheetRegisterNewAccesBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSheetRegisterNewAccesBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }


    companion object {
        fun newInstance() = RegisterNewAccessFragmentSheet()
    }
}