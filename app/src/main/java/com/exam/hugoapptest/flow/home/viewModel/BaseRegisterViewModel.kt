package com.exam.hugoapptest.flow.home.viewModel

import com.exam.hugoapptest.base.BaseViewModel
import com.exam.hugoapptest.di.models.CarModel
import com.exam.hugoapptest.di.models.ListCarAccessRegister
import com.exam.hugoapptest.di.models.ListCarModel
import com.exam.hugoapptest.di.models.NewAccessCar
import com.exam.hugoapptest.preference.PrefsManager
import com.google.gson.Gson

open  class BaseRegisterViewModel : BaseViewModel() {

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
            PrefsManager.instance[PrefsManager.LIST_CAR_ACCESS] = currentList
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

    fun registerExitCar() {

    }
    

    private companion object {
        const val PAYMENT_AMOUNT_RESIDENT = 0.05
        const val PAYMENT_AMOUNT_EXTERNO = 0.5
    }
}