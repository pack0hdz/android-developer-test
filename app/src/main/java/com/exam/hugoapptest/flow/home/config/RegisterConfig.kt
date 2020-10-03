package com.exam.hugoapptest.flow.home.config

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class RegisterConfig(
    val registerTitle: String,
    val registerTime: String,
    val registerOperation: RegisterOperation
): Parcelable

enum class RegisterOperation {
    ACCESS, EXIT
}