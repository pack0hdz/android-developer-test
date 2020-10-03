package com.exam.hugoapptest.flow.home.viewModel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.exam.hugoapptest.base.BaseViewModel
import com.exam.hugoapptest.extensions.isNotNullOrBlank
import javax.inject.Inject

class RegisterViewModel @Inject constructor(

) : BaseRegisterViewModel()  {

    val carRegistrationNumber = MutableLiveData<String>()

    var isButtonRegisterEnable = MediatorLiveData<Boolean>().apply {
        addSource(carRegistrationNumber) { value = validateCompleteData() }
    }

    private fun validateCompleteData() : Boolean {
        return carRegistrationNumber.value.isNotNullOrBlank()
    }
}