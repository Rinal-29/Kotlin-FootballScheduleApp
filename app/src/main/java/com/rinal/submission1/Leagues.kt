package com.rinal.submission1

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Leagues (
    @SerializedName("strLeague")
    val strLeague : String? = null,

    @SerializedName("strDescriptionEN")
    val strDescriptionEN : String? = null
) : Parcelable