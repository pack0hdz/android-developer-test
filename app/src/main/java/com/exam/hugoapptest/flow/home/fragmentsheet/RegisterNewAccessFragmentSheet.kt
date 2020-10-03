package com.exam.hugoapptest.flow.home.fragmentsheet

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exam.hugoapptest.base.BaseBottomSheet
import com.exam.hugoapptest.databinding.FragmentSheetRegisterNewAccesBinding
import com.exam.hugoapptest.flow.home.config.RegisterConfig
import com.exam.hugoapptest.flow.home.viewModel.RegisterViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class RegisterNewAccessFragmentSheet: BaseBottomSheet() {

    @Inject
    lateinit var viewModel: RegisterViewModel

    private lateinit var binding: FragmentSheetRegisterNewAccesBinding

    private var registerConfig: RegisterConfig? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.run {
            registerConfig = getParcelable(REGISTER_CONFIG)
        }
    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setStrings()
        initListener()
    }

    private fun setStrings() {
        binding.apply {
            textViewTitleRegister.text = registerConfig?.registerTitle
            textViewTimeAccess.text = registerConfig?.registerTime
        }
    }

    private fun initListener() {
        binding.buttonRegister.setOnClickListener{ }
    }

    companion object {
        private const val REGISTER_CONFIG = "register_config"

        fun newInstance(config: RegisterConfig): RegisterNewAccessFragmentSheet {

            val args = Bundle().apply {
                putParcelable(REGISTER_CONFIG, config)
            }

            return RegisterNewAccessFragmentSheet().apply {
                arguments = args
            }
        }
    }
}