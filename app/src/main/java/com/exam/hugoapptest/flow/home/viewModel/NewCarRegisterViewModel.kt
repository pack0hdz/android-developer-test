package com.exam.hugoapptest.flow.home.viewModel

import android.view.View
import android.widget.AdapterView
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.exam.hugoapptest.R
import com.exam.hugoapptest.di.models.CarModel
import com.exam.hugoapptest.di.models.CarType
import com.exam.hugoapptest.extensions.default
import com.exam.hugoapptest.extensions.isNotNullOrBlank
import javax.inject.Inject

class NewCarRegisterViewModel @Inject constructor(

) : BaseRegisterViewModel() {

    val carRegistrationNumber = MutableLiveData<String>()
    val carDescription = MutableLiveData<String>()
    val carType = MutableLiveData<CarType>().default(CarType.CAR_OFICIAL)

    var isButtonRegisterEnable = MediatorLiveData<Boolean>().apply {
        addSource(carRegistrationNumber) { value = validateCompleteData() }
    }

    private fun validateCompleteData() : Boolean {
        return carRegistrationNumber.value.isNotNullOrBlank()
    }

    var itemSelectedListener = object: AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(p0: AdapterView<*>?) {
            carType.value = CarType.CAR_OFICIAL
        }

        override fun onItemSelected(
            parent: AdapterView<*>,
            view: View,
            position: Int,
            id: Long
        ) {
            val itemSelected = parent.adapter.getItem(position) as String
            carType.value = if (itemSelected.equals(view.context.getString(R.string.option_car_type_oficial))) {
                CarType.CAR_OFICIAL
            } else {
                CarType.CAR_RESIDENT
            }
        }
    }

    fun saveNewCarRegister() {
        val _carType = carType.value
        val _numberRegister = carRegistrationNumber.value
        val _description = carDescription.value

        val newCarRegister = CarModel(
            _carType,
            _numberRegister,
            _description
        )
    }

}