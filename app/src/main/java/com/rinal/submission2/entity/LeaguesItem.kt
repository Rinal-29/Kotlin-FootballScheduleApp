package com.rinal.submission2.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeaguesItem  (
    @field:SerializedName("strLeague")
    val strLeague : String?,

    @field:SerializedName("strDescriptionEN")
    val strDescriptionEN : String?,

    @field:SerializedName("strTrophy")
    val strTrophy : String?
) : Parcelable