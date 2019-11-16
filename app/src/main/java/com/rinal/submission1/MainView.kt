package com.rinal.submission1

interface MainView {
    fun showLoading()
    fun hideLoading()
    fun showLeagueDetail(data: List<Leagues>)
}