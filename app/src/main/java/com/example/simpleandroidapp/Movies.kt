package com.example.simpleandroidapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies(
    val name: String,
    val photo: String,
    val rating: String,
    val description: String,
    val genre: String
):Parcelable

