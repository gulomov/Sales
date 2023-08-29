package com.myproject.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AboutApp(
    @Json(name = "about_app")
    val aboutApp: String,
)
