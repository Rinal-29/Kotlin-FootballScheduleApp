package com.rinal.submission2.leagues

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.rinal.submission2.R
import com.rinal.submission2.entity.Item
import com.rinal.submission2.entity.LeaguesResponse
import com.rinal.submission2.invisible
import com.rinal.submission2.repository.Repository
import com.rinal.submission2.ui.DetailLeagueUI
import com.rinal.submission2.ui.DetailLeagueUI.Companion.descTextView
import com.rinal.submission2.ui.DetailLeagueUI.Companion.logoImageView
import com.rinal.submission2.ui.DetailLeagueUI.Companion.nameTextView
import com.rinal.submission2.ui.DetailLeagueUI.Companion.progressBar
import com.rinal.submission2.ui.DetailLeagueUI.Companion.tabLayout
import com.rinal.submission2.ui.DetailLeagueUI.Companion.viewPagerLayout
import com.rinal.submission2.visible
import com.squareup.picasso.Picasso
import org.jetbrains.anko.setContentView

class DetailLeagues : AppCompatActivity(), LeaguesView {

    private var name: String = ""
    private var desc: String = ""
    private var trophyImg: String = ""

    lateinit var presenter: LeaguesPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DetailLeagueUI().setContentView(this)

        val items = intent.getParcelableExtra<Item>("EXTRA_ITEM")

        val viewPger = findViewById<View>(viewPagerLayout) as ViewPager
        viewPger.adapter = PagerAdapter(supportFragmentManager, this)
        tabLayout.setupWithViewPager(viewPger)
        tabLayout.setTabTextColors(Color.WHITE, R.color.colorCostum)

        presenter = LeaguesPresenter(this, Repository())

        presenter.getLeague(items?.id.toString())

        supportActionBar?.setTitle(getString(R.string.detail_league))
    }

    override fun onDataLoaded(data: LeaguesResponse?) {
        data?.leagues?.let {
            name = it.get(0).strLeague!!
            desc = it.get(0).strDescriptionEN!!
            trophyImg = it.get(0).strTrophy!!
        }

        Picasso.get()
            .load(trophyImg)
            .into(logoImageView)
        nameTextView.text = name
        descTextView.text = desc
    }

    override fun onDataError() {
        Toast.makeText(this, "Gagal Mendapatkan data", Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar() {
        progressBar.visible()
    }

    override fun hideProgressBar() {
        progressBar.invisible()
    }
}


