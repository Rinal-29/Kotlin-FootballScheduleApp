package com.rinal.submission1

import android.net.Uri

object TheSportDBApi {
    fun getLeagues(id: String?)  =
        Uri.parse(BuildConfig.BASE_URL).buildUpon().
                appendPath("api").
                appendPath("v1").
                appendPath("json").
                appendPath(BuildConfig.TSDB_API_KEY).
                appendPath("lookupleague.php").
                appendQueryParameter("id", id).
                build().
                toString()
}