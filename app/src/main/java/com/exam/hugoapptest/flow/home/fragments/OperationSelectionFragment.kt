package com.exam.hugoapptest.flow.home.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.exam.hugoapptest.base.BaseFragment
import com.exam.hugoapptest.databinding.FragmentOperationSelectionBinding

class OperationSelectionFragment: BaseFragment() {

    private val binding: FragmentOperationSelectionBinding by lazy {
        FragmentOperationSelectionBinding.inflate(layoutInflater)
    }

    private var listener: OperationListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? OperationListener
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.apply {
            cardViewRegisterNewAccess.setOnClickListener {  }
            cardViewRegisterExit.setOnClickListener {  }
            cardViewCarRegister.setOnClickListener {  }
            cardViewStartMonth.setOnClickListener {  }
            cardViewResidentPayment.setOnClickListener {  }
        }
    }

    interface OperationListener{
        fun onRegisterNewAccess()
        fun onRegisterExist()
        fun onRegisterNewCar()
        fun onStartMonth()
        fun onPaymentResident()
    }
}