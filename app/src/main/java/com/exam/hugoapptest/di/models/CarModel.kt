package com.exam.hugoapptest.di.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class CarModel(
    val carType: CarType?,
    val carRegistrationNumber: String?,
    val carDescription: String?
)

@Parcelize
data class ListCarModel (
    val listCar: @RawValue MutableList<CarModel>
): Parcelable