package com.rinal.submission2.entity

import com.google.gson.annotations.SerializedName

data class MatchResponse (
    @field:SerializedName("events")
    val events : List<MatchItem>? = null,

    @field:SerializedName("event")
    val event : List<MatchItem>? = null,

    @field:SerializedName("teams")
    val teams : List<Teams>? = null
)