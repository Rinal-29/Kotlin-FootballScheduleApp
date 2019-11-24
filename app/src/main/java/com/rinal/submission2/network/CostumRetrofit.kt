package com.rinal.submission2.network

import com.rinal.submission2.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CostumRetrofit {
    private fun buildRetrofit() : Retrofit {
        return Retrofit.Builder().
                baseUrl(BuildConfig.BASE_URL).
                addConverterFactory(GsonConverterFactory.create()).
                build()
    }

    fun <T> createService(service : Class<T>): T {
        return buildRetrofit().create(service)
    }

}