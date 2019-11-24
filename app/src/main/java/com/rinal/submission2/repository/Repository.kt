package com.rinal.submission2.repository

import com.rinal.submission2.entity.LeaguesResponse
import com.rinal.submission2.entity.MatchResponse
import com.rinal.submission2.entity.TeamsResponse
import com.rinal.submission2.network.ApiRepository
import com.rinal.submission2.network.CostumRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {
    fun getLeagues(id: String, callback: RepositoryCallback<LeaguesResponse>) {
        CostumRetrofit
            .createService(ApiRepository::class.java)
            .getLeagues(id)
            .enqueue(object : Callback<LeaguesResponse>{
                override fun onFailure(call: Call<LeaguesResponse>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(
                    call: Call<LeaguesResponse>,
                    response: Response<LeaguesResponse>) {

                    response.let {
                        if(it.isSuccessful){
                            callback.onDataLoaded(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }

                }
            })
    }

    fun getNextMatch(id: String, callback: RepositoryCallback<MatchResponse>) {
        CostumRetrofit
            .createService(ApiRepository::class.java)
            .getNextMatch(id)
            .enqueue(object : Callback<MatchResponse>{
                override fun onFailure(call: Call<MatchResponse>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(
                    call: Call<MatchResponse>,
                    response: Response<MatchResponse>
                ) {
                    response.let {
                        if(it.isSuccessful){
                            callback.onDataLoaded(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }
                }
            })
    }

    fun getTeams(t: String, callback: RepositoryCallback<TeamsResponse>){
        CostumRetrofit
            .createService(ApiRepository::class.java)
            .getTeams(t)
            .enqueue(object : Callback<TeamsResponse> {
                override fun onFailure(call: Call<TeamsResponse>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(
                    call: Call<TeamsResponse>,
                    response: Response<TeamsResponse>
                ) {
                    response.let {
                        if(it.isSuccessful){
                            callback.onDataLoaded(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }
                }
            })
    }

    fun getTeamsId(id: String, callback: RepositoryCallback<TeamsResponse>){
        CostumRetrofit
            .createService(ApiRepository::class.java)
            .getTeamsId(id)
            .enqueue(object : Callback<TeamsResponse>{
                override fun onFailure(call: Call<TeamsResponse>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(
                    call: Call<TeamsResponse>,
                    response: Response<TeamsResponse>
                ) {
                    response.let {
                        if (it.isSuccessful){
                            callback.onDataLoaded(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }
                }
            })
    }

    fun getPevMatch(id: String, callback: RepositoryCallback<MatchResponse>){
        CostumRetrofit
            .createService(ApiRepository::class.java)
            .getPastLeague(id)
            .enqueue(object : Callback<MatchResponse>{
                override fun onFailure(call: Call<MatchResponse>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(
                    call: Call<MatchResponse>,
                    response: Response<MatchResponse>
                ) {
                    response.let {
                        if (it.isSuccessful){
                            callback.onDataLoaded(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }
                }

            })
    }

    fun getEvents(e: String, callback: RepositoryCallback<MatchResponse>){
        CostumRetrofit
            .createService(ApiRepository::class.java)
            .getEvents(e)
            .enqueue(object : Callback<MatchResponse>{
                override fun onFailure(call: Call<MatchResponse>, t: Throwable) {
                    callback.onDataError()
                }

                override fun onResponse(
                    call: Call<MatchResponse>,
                    response: Response<MatchResponse>
                ) {
                    response.let {
                        if (it.isSuccessful){
                            callback.onDataLoaded(it.body())
                        } else {
                            callback.onDataError()
                        }
                    }
                }

            })
    }
}


