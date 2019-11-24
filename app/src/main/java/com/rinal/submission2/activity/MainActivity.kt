package com.rinal.submission2.activity

import android.annotation.SuppressLint
import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rinal.submission2.R
import com.rinal.submission2.entity.Item
import com.rinal.submission2.entity.MatchItem
import com.rinal.submission2.entity.MatchResponse
import com.rinal.submission2.invisible
import com.rinal.submission2.leagues.DetailLeagues
import com.rinal.submission2.match.DetailMatch
import com.rinal.submission2.match.MatchAdapter
import com.rinal.submission2.match.MatchPresenter
import com.rinal.submission2.match.MatchView
import com.rinal.submission2.repository.Repository
import com.rinal.submission2.visible
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity(), MatchView {

    private var items : MutableList<Item> = mutableListOf()
    private var matchItem : MutableList<MatchItem> = mutableListOf()
    lateinit var presenter: MatchPresenter

    lateinit var itemAdapter: ItemAdapter
    lateinit var matchAdapter: MatchAdapter

    companion object {
        lateinit var rvMain : RecyclerView

        @SuppressLint("StaticFieldLeak")
        lateinit var imgEmpty: ImageView

        @SuppressLint("StaticFieldLeak")
        lateinit var tvEmpty: TextView

        @SuppressLint("StaticFieldLeak")
        lateinit var linearLayout : LinearLayout
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        relativeLayout {
            lparams(matchParent, matchParent)
            padding = dip(16)

            rvMain = recyclerView {
                lparams(matchParent, matchParent)
            }

            linearLayout =  verticalLayout {
                lparams{
                    height = matchParent
                    width = matchParent
                }
                visibility = View.GONE
                gravity = Gravity.CENTER

                imgEmpty = imageView {
                    backgroundResource =
                        R.drawable.ic_sentiment_dissatisfied_black_24dp
                }.lparams{
                    width = dip(200)
                    height = dip(200)
                    gravity = Gravity.CENTER
                }

                tvEmpty = textView {
                    textSize = 20f
                    text = context.getString(R.string.not_found)
                    textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                }.lparams(matchParent, wrapContent)
            }
        }

        val id = resources.getStringArray(R.array.leagueId)
        val image = resources.obtainTypedArray(R.array.img_league)
        val name = resources.getStringArray(R.array.name_league)

        items.clear()

        for (i in id.indices) {
            items.add(Item(id[i], name[i] ,image.getResourceId(i,0)))
        }

        image.recycle()

        itemAdapter = ItemAdapter(items) {
            startActivity<DetailLeagues>("EXTRA_ITEM" to it)
        }

        rvMain.layoutManager = LinearLayoutManager(this)
        rvMain.adapter = itemAdapter

        presenter = MatchPresenter(this, Repository())

        supportActionBar?.setTitle(getString(R.string.league_list))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)

        val searchManager : SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        val searchView : SearchView = menu?.findItem(R.id.search)?.actionView as SearchView

        searchView.setSearchableInfo(
            searchManager.getSearchableInfo(componentName)
        )

        searchView.isIconifiedByDefault = false
        searchView.queryHint = getString(R.string.match_search)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query : String?): Boolean {
                presenter.getEvents(query!!)
                return false
            }

            override fun onQueryTextChange(newtext : String?): Boolean {
                return false
            }
        })
        return true
    }

    override fun onDataLoaded(data: MatchResponse?) {

        if (data?.event == null){
            linearLayout.visible()
            rvMain.invisible()
        } else {
            data.event.let {
                matchItem.addAll(it)
            }

            matchAdapter = MatchAdapter(matchItem) {
                startActivity<DetailMatch>("MATCH_ITEM" to it)
            }
            rvMain.layoutManager = LinearLayoutManager(this)
            rvMain.adapter = matchAdapter
        }
    }

    override fun onDataError() {
        Toast.makeText(applicationContext, "Gagal mencari", Toast.LENGTH_SHORT).show()
    }
}




