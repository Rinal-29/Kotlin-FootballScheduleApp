package com.rinal.submission2.match.teams

import com.rinal.submission2.entity.TeamsResponse
import com.rinal.submission2.repository.Repository
import com.rinal.submission2.repository.RepositoryCallback

class TeamsPresenter (private val view : TeamsView, private val repository: Repository) {
    fun getTeamHome(t1 : String) {
        repository.getTeams(t1 , object : RepositoryCallback<TeamsResponse>{
            override fun onDataLoaded(data: TeamsResponse?) {
                view.onDataLoaded(data)
            }

            override fun onDataError() {
                view.onDataError()
            }

        })
    }

    fun getTeamAway(id: String){
        repository.getTeamsId(id, object : RepositoryCallback<TeamsResponse>{
            override fun onDataLoaded(data: TeamsResponse?) {
                view.showData(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
    }
}