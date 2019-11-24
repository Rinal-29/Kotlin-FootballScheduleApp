package com.rinal.submission2.match

import com.rinal.submission2.entity.MatchResponse
import com.rinal.submission2.repository.Repository
import com.rinal.submission2.repository.RepositoryCallback

class MatchPresenter (private val view : MatchView, private val repository: Repository){
    fun getNextMatch (id : String) {
        repository.getNextMatch(id, object : RepositoryCallback<MatchResponse>{
            override fun onDataLoaded(data: MatchResponse?) {
                view.onDataLoaded(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
    }

    fun getPrevMatch (id : String){
        repository.getPevMatch(id, object : RepositoryCallback<MatchResponse>{
            override fun onDataLoaded(data: MatchResponse?) {
                view.onDataLoaded(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
    }

    fun getEvents (e : String) {
        repository.getEvents(e, object : RepositoryCallback<MatchResponse>{
            override fun onDataLoaded(data: MatchResponse?) {
                view.onDataLoaded(data)
            }

            override fun onDataError() {
                view.onDataError()
            }
        })
    }
}