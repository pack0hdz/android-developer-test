package com.exam.hugoapptest.di.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class NewAccessCar(
    val carModel: CarModel? = null,
    val carAccessTime: Long? = null,
    var carExitCar: Long? = null,
    var carTotalPayment: Double? = null
)

@Parcelize
data class ListCarAccessRegister (
    val listCar: @RawValue MutableList<NewAccessCar>
): Parcelable
