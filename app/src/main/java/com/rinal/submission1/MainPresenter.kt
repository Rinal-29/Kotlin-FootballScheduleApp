package com.rinal.submission1

import com.google.gson.Gson
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MainPresenter (private val view: MainView,
                     private val apiRepository: ApiRepository,
                     private val gson: Gson) {

    fun getLeagueList(id:String?) {

        doAsync {
            val data = gson.fromJson(apiRepository
                .doRequest(TheSportDBApi.getLeagues(id)),
                LeaguesResponse::class.java)

            uiThread {
                view.showLeagueDetail(data.leagues)
            }
        }
    }
}