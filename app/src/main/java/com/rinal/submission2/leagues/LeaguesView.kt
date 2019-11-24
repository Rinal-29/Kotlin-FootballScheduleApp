package com.rinal.submission2.leagues

import com.rinal.submission2.entity.LeaguesResponse
import com.rinal.submission2.repository.RepositoryCallback

interface LeaguesView : RepositoryCallback<LeaguesResponse> {
    fun showProgressBar()
    fun hideProgressBar()
}