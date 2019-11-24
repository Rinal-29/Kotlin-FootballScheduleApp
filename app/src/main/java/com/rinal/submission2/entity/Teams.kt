package com.rinal.submission2.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Teams (
    @field:SerializedName("strTeamBadge")
    val strTeamBadge : String?
) : Parcelable