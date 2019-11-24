package com.rinal.submission2.match

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rinal.submission2.entity.MatchItem
import com.rinal.submission2.entity.TeamsResponse
import com.rinal.submission2.match.teams.TeamsPresenter
import com.rinal.submission2.match.teams.TeamsView
import com.rinal.submission2.repository.Repository
import com.rinal.submission2.ui.MatchListUI
import com.rinal.submission2.ui.MatchListUI.Companion.date_match
import com.rinal.submission2.ui.MatchListUI.Companion.img_away
import com.rinal.submission2.ui.MatchListUI.Companion.img_home
import com.rinal.submission2.ui.MatchListUI.Companion.name_away
import com.rinal.submission2.ui.MatchListUI.Companion.name_home
import com.rinal.submission2.ui.MatchListUI.Companion.scor_away
import com.rinal.submission2.ui.MatchListUI.Companion.scor_home
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext
import java.text.SimpleDateFormat
import java.util.*

class MatchAdapter(private val listMatch : List<MatchItem>?, private val listener : (MatchItem) -> Unit)
    : RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  =
        ViewHolder(
            MatchListUI().createView(
                AnkoContext.create(
                    parent.context,
                    parent
                )
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listMatch?.get(position)!!, listener)
    }

    override fun getItemCount() = listMatch?.size!!

    class ViewHolder (override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer, TeamsView {

        var badgeHome = ""
        var badgeAway = ""

        lateinit var presenter: TeamsPresenter

        val nameHome = itemView.findViewById<TextView>(name_home)
        val nameAway = itemView.findViewById<TextView>(name_away)
        val dateMatch = itemView.findViewById<TextView>(date_match)
        val imgHome = itemView.findViewById<ImageView>(img_home)
        val imgAway = itemView.findViewById<ImageView>(img_away)
        val scoreHome = itemView.findViewById<TextView>(scor_home)
        val scoreAway = itemView.findViewById<TextView>(scor_away)

        fun bindItem(matchItem: MatchItem?, listener: (MatchItem) -> Unit) {
            presenter = TeamsPresenter(this, Repository())

            nameHome.text = matchItem?.strHomeTeam
            nameAway.text = matchItem?.strAwayTeam

            val date = FormatDate(matchItem?.dateEvent!!)
            dateMatch.text = date.toString()

            if (matchItem.intHomeScore == null){
                scoreHome.text = "0"
            } else {
                scoreHome.text = matchItem.intHomeScore
            }

            if (matchItem.intAwayScore == null){
                scoreAway.text = "0"
            } else {
                scoreAway.text = matchItem.intAwayScore
            }

            presenter.getTeamHome(matchItem.strHomeTeam!!)
            presenter.getTeamAway(matchItem.idAwayTeam!!)

            itemView.setOnClickListener {
                listener(matchItem)
            }
        }

        override fun onDataLoaded(data: TeamsResponse?) {
            data?.teams.let {
                badgeHome = it?.get(0)?.strTeamBadge!!
            }
            Picasso.get().load(badgeHome).into(imgHome)
        }

        override fun showData(data: TeamsResponse?) {
            data?.teams.let {
                badgeAway = it?.get(0)?.strTeamBadge!!
            }
            Picasso.get().load(badgeAway).into(imgAway)
        }

        override fun onDataError() {

        }

        fun FormatDate(date: String) : Date? {
            val formater = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            formater.timeZone = TimeZone.getTimeZone("GMT+7")
            return formater.parse(date)
        }
    }
}