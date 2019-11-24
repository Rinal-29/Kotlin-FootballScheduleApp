package com.rinal.submission2.leagues

import com.rinal.submission2.entity.LeaguesResponse
import com.rinal.submission2.repository.Repository
import com.rinal.submission2.repository.RepositoryCallback

class LeaguesPresenter(private val view : LeaguesView, private val repository: Repository) {

    fun getLeague(id: String) {
        view.showProgressBar()
        repository.getLeagues(id, object : RepositoryCallback<LeaguesResponse>{
            override fun onDataLoaded(data: LeaguesResponse?) {
                view.hideProgressBar()
                view.onDataLoaded(data)
            }

            override fun onDataError() {
                view.onDataError()
            }

        })
    }
}

