package com.rinal.submission2.match.teams

import com.rinal.submission2.entity.TeamsResponse
import com.rinal.submission2.repository.RepositoryCallback

interface TeamsView : RepositoryCallback<TeamsResponse> {
    fun showData(data : TeamsResponse?)
}