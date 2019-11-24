package com.rinal.submission2.match.nextmatch

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rinal.submission2.match.DetailMatch
import com.rinal.submission2.R
import com.rinal.submission2.entity.Item
import com.rinal.submission2.entity.MatchItem
import com.rinal.submission2.entity.MatchResponse
import com.rinal.submission2.invisible
import com.rinal.submission2.match.MatchAdapter
import com.rinal.submission2.match.MatchPresenter
import com.rinal.submission2.match.MatchView
import com.rinal.submission2.repository.Repository
import com.rinal.submission2.visible
import kotlinx.android.synthetic.main.fragment_next_match.*
import org.jetbrains.anko.support.v4.startActivity

class NextMatchFragment : Fragment(), MatchView {

    lateinit var presenterMatch: MatchPresenter
    lateinit var adapter: MatchAdapter

    private val matchItem: MutableList<MatchItem> = mutableListOf()
    lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val intent = activity?.intent
        val items = intent?.getParcelableExtra<Item>("EXTRA_ITEM")
        val idLeague = items?.id
        presenterMatch = MatchPresenter(this, Repository())
        presenterMatch.getNextMatch(idLeague!!)
        return inflater.inflate(R.layout.fragment_next_match, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        progressBar = view.findViewById(R.id.progressBar)
        progressBar.visible()
    }

    override fun onDataLoaded(data: MatchResponse?) {
        matchItem.clear()
        data?.events?.let {
            matchItem.addAll(it)
        }

        progressBar.invisible()
        adapter = MatchAdapter(matchItem) {
            startActivity<DetailMatch>("MATCH_ITEM" to it)
        }
        rvMatchNext.layoutManager = LinearLayoutManager(context)
        rvMatchNext.adapter = adapter
    }

    override fun onDataError() {
        Toast.makeText(context, "GAGAL MENDAPATKAN DATA", Toast.LENGTH_SHORT).show()
    }
}
