package com.rinal.submission1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item (val id: String? , val name: String?, val image: Int?, val description: String? ) : Parcelable