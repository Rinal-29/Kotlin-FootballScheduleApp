package com.rinal.submission2.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MatchItem (
    @field:SerializedName("idEvent")
    val idEvent : String?,

    @field:SerializedName("strHomeTeam")
    val strHomeTeam : String?,

    @field:SerializedName("strAwayTeam")
    val strAwayTeam : String?,

    @field:SerializedName("dateEvent")
    val dateEvent : String?,

    @field:SerializedName("strTime")
    val strTime : String?,

    @field:SerializedName("idHomeTeam")
    val idHomeTeam : String?,

    @field:SerializedName("idAwayTeam")
    val idAwayTeam : String?,

    @field:SerializedName("intHomeScore")
    val intHomeScore : String?,

    @field:SerializedName("intAwayScore")
    val intAwayScore : String?,

    @field:SerializedName("strHomeGoalDetails")
    val homeGoalDetails : String?,

    @field:SerializedName("strHomeRedCards")
    val homeRedCards : String?,

    @field:SerializedName("strHomeYellowCards")
    val homeYellowCards : String?,

    @field:SerializedName("strAwayGoalDetails")
    val awayGoalDetails : String?,

    @field:SerializedName("strAwayRedCards")
    val awayRedCards : String?,

    @field:SerializedName("strAwayYellowCards")
    val awayYellowCards : String?

) : Parcelable