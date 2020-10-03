package com.exam.hugoapptest.flow.home.viewModel

import com.exam.hugoapptest.base.BaseViewModel
import com.exam.hugoapptest.di.models.CarModel
import com.exam.hugoapptest.di.models.CarType
import com.exam.hugoapptest.di.models.ListCarAccessRegister
import com.exam.hugoapptest.di.models.ListCarModel
import com.exam.hugoapptest.di.models.NewAccessCar
import com.exam.hugoapptest.preference.PrefsManager
import com.google.gson.Gson
import java.util.function.DoubleBinaryOperator

open  class BaseRegisterViewModel : BaseViewModel() {

    fun registerHistoric(itemCar: NewAccessCar) {

        val currentList = PrefsManager.instance.getString(PrefsManager.LIST_HISTORIC_ACCESS, "")
        var currentListJson: ListCarAccessRegister? = null

        if (currentList?.isNotEmpty()!!) {
            currentListJson = Gson().fromJson(currentList, ListCarAccessRegister::class.java) as ListCarAccessRegister
            currentListJson.listCar.add(itemCar)
            PrefsManager.instance[PrefsManager.LIST_HISTORIC_ACCESS] = Gson().toJson(currentListJson)
        } else {
            val listCar = ListCarAccessRegister(
                listCar = mutableListOf(
                    itemCar
                )
            )
            val _listCar = Gson().toJson(listCar)
            PrefsManager.instance[PrefsManager.LIST_HISTORIC_ACCESS] = _listCar
        }
    }

    fun registerNewCar(itemCar: CarModel) {

        val currentList = PrefsManager.instance.getString(PrefsManager.LIST_CAR_REGISTERED, "")
        var currentListJson: ListCarModel? = null

        if (currentList?.isNotEmpty()!!) {
            currentListJson = Gson().fromJson(currentList, ListCarModel::class.java) as ListCarModel
            currentListJson.listCar.add(itemCar)
            PrefsManager.instance[PrefsManager.LIST_CAR_REGISTERED] = Gson().toJson(currentListJson)
        } else {
            val listCar = ListCarModel(
                listCar =  mutableListOf(
                    itemCar
                )
            )

            PrefsManager.instance[PrefsManager.LIST_CAR_REGISTERED] =  Gson().toJson(listCar)
        }
    }

    fun registerNewAccess(itemCar: NewAccessCar) {
        val currentList = PrefsManager.instance.getString(PrefsManager.LIST_CAR_ACCESS, "")
        var currentListJson: ListCarAccessRegister? = null

        if (currentList?.isNotEmpty()!!) {
            currentListJson = Gson().fromJson(currentList, ListCarAccessRegister::class.java) as ListCarAccessRegister
            currentListJson.listCar.add(itemCar)
            PrefsManager.instance[PrefsManager.LIST_CAR_ACCESS] = Gson().toJson(currentListJson)
        } else {
            val listCar = ListCarAccessRegister(
                listCar = mutableListOf(
                    itemCar
                )
            )
            val _listCar = Gson().toJson(listCar)
            PrefsManager.instance[PrefsManager.LIST_CAR_ACCESS] = _listCar
        }
    }

    fun isCarRegistered(registrationNumber: String): Pair<Boolean, CarModel> {
        val currentList = PrefsManager.instance.getString(PrefsManager.LIST_CAR_REGISTERED, "")
        var currentListJson: ListCarModel? = null

        return if (currentList.isNullOrEmpty()) {
            Pair(false, CarModel())
        } else {
            currentListJson = Gson().fromJson(currentList, ListCarModel::class.java) as ListCarModel

            val anyItemCarModel = currentListJson.listCar.any { it.carRegistrationNumber == registrationNumber }
            var currentItem = CarModel()

            if (anyItemCarModel) {
                currentItem = currentListJson.listCar.first { it.carRegistrationNumber == registrationNumber }
            }

            return Pair(anyItemCarModel, currentItem)
        }
    }

    fun isCarAccessRegistered(registrationNumber: String): Pair<Boolean, NewAccessCar> {
        val currentList = PrefsManager.instance.getString(PrefsManager.LIST_CAR_ACCESS, "")
        var currentListJson: ListCarAccessRegister? = null

        return if (currentList.isNullOrEmpty()) {
            Pair(false, NewAccessCar())
        } else {
            currentListJson = Gson().fromJson(currentList, ListCarAccessRegister::class.java) as ListCarAccessRegister

            val anyItemCarModel = currentListJson.listCar.any { it.carModel?.carRegistrationNumber == registrationNumber }
            var currentItem = NewAccessCar()

            if (anyItemCarModel) {
                currentItem = currentListJson.listCar.first { it.carModel?.carRegistrationNumber == registrationNumber }
                updateList(currentListJson.listCar.filter { it != currentItem })
            }

            return Pair(anyItemCarModel, currentItem)
        }
    }

    private fun updateList(currentList: List<NewAccessCar>) {
        var currentListJson: ListCarAccessRegister? = null

        if (currentList.isNotEmpty()) {

            currentList.forEach {
                currentListJson = ListCarAccessRegister(
                    mutableListOf(it)
                )
            }

            PrefsManager.instance[PrefsManager.LIST_CAR_ACCESS] = Gson().toJson(currentListJson)
        } else {
            PrefsManager.instance[PrefsManager.LIST_CAR_ACCESS] =  ""
        }
    }

    fun getTotalPayment(carType: CarType?, totalMinutes: Int): Double {
        return when(carType) {
            CarType.CAR_NO_RESIDENT -> totalMinutes * PAYMENT_AMOUNT_EXTERNO
            CarType.CAR_RESIDENT -> totalMinutes * PAYMENT_AMOUNT_RESIDENT
            else -> 0.toDouble()
        }
    }

    private companion object {
        const val PAYMENT_AMOUNT_RESIDENT = 0.05
        const val PAYMENT_AMOUNT_EXTERNO = 0.5
    }
}