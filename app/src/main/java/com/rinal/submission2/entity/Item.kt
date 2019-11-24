package com.rinal.submission2.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val id: String?, val name: String? ,val image: Int?) : Parcelable