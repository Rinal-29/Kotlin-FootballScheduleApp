package com.rinal.submission2.entity

import com.google.gson.annotations.SerializedName

data class LeaguesResponse (

    @field:SerializedName("leagues")
    val leagues: List<LeaguesItem>? = null
)