package com.exam.hugoapptest.flow.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import com.exam.hugoapptest.di.models.NewAccessCar
import com.exam.hugoapptest.extensions.isNotNullOrBlank
import com.exam.hugoapptest.flow.home.config.RegisterOperation
import java.util.Date
import javax.inject.Inject

class RegisterViewModel @Inject constructor(

) : BaseRegisterViewModel()  {

    val carRegistrationNumber = MutableLiveData<String>()
    private val showTotalPrice = MutableLiveData<Pair<String, String>>()

    var isButtonRegisterEnable = MediatorLiveData<Boolean>().apply {
        addSource(carRegistrationNumber) { value = validateCompleteData() }
    }

    fun getTotalPrices(): LiveData<Pair<String, String>> = showTotalPrice

    private fun validateCompleteData() : Boolean {
        return carRegistrationNumber.value.isNotNullOrBlank()
    }

    fun doAction(carType: RegisterOperation?) {
        when (carType) {
            RegisterOperation.ACCESS -> handleAccessCar()
            RegisterOperation.EXIT -> handleExitCar()
        }
    }

    private fun handleAccessCar() {
        var newRegister: NewAccessCar? = null
        val registeredCar = isCarRegistered(carRegistrationNumber.value!!)
        val date = Date()

        if (registeredCar.first) {
            newRegister = NewAccessCar(
                carModel = registeredCar.second,
                carAccessTime = date.time
            )
            registerNewAccess(newRegister)
            showMessageText.value = date.toString()
        } else {
            showMessageText.value = "Vehículo no registrado"
        }
    }

    private fun handleExitCar() {
        var newRegister: NewAccessCar? = null
        val registeredCar = isCarAccessRegistered(carRegistrationNumber.value!!)
        val date = Date()
        var totalMinutes: Int? = null
        var totalPriceToPay: Double? = null

        if (registeredCar.first) {
            newRegister = registeredCar.second
            newRegister.carExitCar = date.time
            totalMinutes = getDifferenceBetwenDates(newRegister.carAccessTime!!, newRegister.carExitCar!!)
            totalPriceToPay = getTotalPayment(newRegister.carModel?.carType, totalMinutes)
            newRegister.carTotalPayment = totalPriceToPay
            showTotalPrice.value = Pair("$totalPriceToPay", "Total Minutos: $totalMinutes")
        } else {
            showMessageText.value = "Verificar placa del vehículo"
        }
    }

    fun getDifferenceBetwenDates(
        startDate: Long,
        endDate: Long
    ): Int {
        val milliseconds = endDate - startDate
        val seconds = (milliseconds / 1000).toInt() % 60
        val minutes = (milliseconds / (1000 * 60) % 60).toInt()
        return minutes
    }
}