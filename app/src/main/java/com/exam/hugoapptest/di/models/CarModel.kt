package com.exam.hugoapptest.di.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class CarModel(
    val carType: CarType? = null,
    val carRegistrationNumber: String? = null,
    val carDescription: String? = null
)

@Parcelize
data class ListCarModel(
    val listCar: @RawValue MutableList<CarModel>
) : Parcelable