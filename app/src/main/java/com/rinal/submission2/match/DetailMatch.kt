package com.rinal.submission2.match

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rinal.submission2.R
import com.rinal.submission2.entity.MatchItem
import com.rinal.submission2.entity.TeamsResponse
import com.rinal.submission2.invisible
import com.rinal.submission2.match.teams.TeamsPresenter
import com.rinal.submission2.match.teams.TeamsView
import com.rinal.submission2.repository.Repository
import com.rinal.submission2.visible
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_match.*

class DetailMatch : AppCompatActivity(), TeamsView {

    lateinit var presenter: TeamsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_match)
        progressBar.visible()

        val matchItem = intent.getParcelableExtra<MatchItem>("MATCH_ITEM")

        tvNameHome.text = matchItem!!.strHomeTeam
        tvNameAway.text = matchItem.strAwayTeam
        homeGoalDetails.text = matchItem.homeGoalDetails
        homeRedCard.text = matchItem.homeRedCards
        homeYellowCard.text = matchItem.homeYellowCards
        awayGoalDetails.text = matchItem.awayGoalDetails
        awayYellowCard.text = matchItem.awayRedCards
        awayYellowCard.text = matchItem.awayRedCards

        if (matchItem.intHomeScore == null){
            tvHomeScore.text = "0"
        } else {
            tvHomeScore.text = matchItem.intHomeScore
        }

        if (matchItem.intAwayScore == null){
            tvAwayScore.text = "0"
        } else {
            tvAwayScore.text = matchItem.intAwayScore
        }

        presenter = TeamsPresenter(this, Repository())
        presenter.getTeamHome(matchItem.strHomeTeam!!)
        presenter.getTeamAway(matchItem.idAwayTeam!!)

        supportActionBar?.setTitle(getString(R.string.detail_match))
    }


    override fun onDataLoaded(data: TeamsResponse?) {
        progressBar.invisible()
        data?.teams.let {
            val home = it?.get(0)?.strTeamBadge!!

            Picasso.get().load(home).into(badgeHome)
        }
    }

    override fun showData(data: TeamsResponse?) {
        progressBar.invisible()
        data?.teams.let {
            val away = it?.get(0)?.strTeamBadge!!
            Picasso.get().load(away).into(badgeAway)
        }
    }

    override fun onDataError() {

    }
}
