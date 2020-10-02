package com.exam.hugoapptest.extensions

import android.view.View
import android.view.ViewGroup
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

fun View.removeFromParent() {
    this.parent?.let {
        (it as ViewGroup).removeView(this)
    }
}

fun View.show(show: Boolean) {
    if (show) {
        show()
    } else {
        hide()
    }
}

fun View.showOrDisappear(show: Boolean) {
    if (show) {
        show()
    } else {
        disappear()
    }
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun View.hide() {
    this.visibility = View.GONE
}

fun View.disappear() {
    this.visibility = View.INVISIBLE
}

fun isJsonValid(test: String): Boolean {
    try {
        JSONObject(test)
    } catch (ex: JSONException) {
        try {
            JSONArray(test)
        } catch (ex1: JSONException) {
            return false
        }
    }
    return true
}

inline fun <T> tryOrDefault(f: () -> T, defaultValue: T): T {
    return try {
        f()
    } catch (e: Exception) {
        e.printStackTrace()
        defaultValue
    }
}

fun JsonObject?.getJsonObjectOrDefault(key: String, defaultValue: JsonObject? = null): JsonObject? =
    tryOrDefault({
        getJsonElementOrDefault(key)?.asJsonObject ?: defaultValue
    }, defaultValue)

fun JsonObject?.getJsonElementOrDefault(key: String, defaultValue: JsonElement? = null): JsonElement? =
    tryOrDefault({
        if (this?.get(key)?.isJsonNull == false) {
            this.get(key) ?: defaultValue
        } else {
            defaultValue
        }
    }, defaultValue)