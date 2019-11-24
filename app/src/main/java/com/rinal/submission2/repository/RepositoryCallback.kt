package com.rinal.submission2.repository

interface RepositoryCallback<T> {

    fun onDataLoaded(data: T?)
    fun onDataError()
}