package com.rinal.submission2.network

import com.rinal.submission2.entity.LeaguesResponse
import com.rinal.submission2.entity.MatchResponse
import com.rinal.submission2.entity.TeamsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiRepository {
    @GET("api/v1/json/1/lookupleague.php")
    fun getLeagues(@Query("id") id: String) : Call<LeaguesResponse>

    @GET("api/v1/json/1/eventsnextleague.php")
    fun getNextMatch(@Query("id") id: String) : Call<MatchResponse>

    @GET("api/v1/json/1/searchteams.php")
    fun getTeams(@Query("t") t: String) : Call<TeamsResponse>

    @GET("api/v1/json/1/lookupteam.php")
    fun getTeamsId(@Query("id") id: String) : Call<TeamsResponse>

    @GET("api/v1/json/1/eventspastleague.php")
    fun getPastLeague(@Query("id") id : String) : Call<MatchResponse>

    @GET("api/v1/json/1/searchevents.php")
    fun getEvents(@Query("e") e: String) : Call<MatchResponse>
}