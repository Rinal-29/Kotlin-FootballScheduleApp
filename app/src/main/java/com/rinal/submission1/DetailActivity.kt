package com.rinal.submission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity(), MainView {

    private var name: String = ""
    private var desc: String = ""

    lateinit var nameTextView: TextView
    lateinit var logoImageView: ImageView
    lateinit var descTextView: TextView

    private var leagues : MutableList<Leagues> = mutableListOf()

    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setTitle("Detail League")

        scrollView {
            padding = dip(16)

            verticalLayout{
                logoImageView = imageView{}.lparams(width = matchParent, height = dip(400)){
                    bottomMargin = dip(16)
                }

                nameTextView = textView{}.lparams(width = matchParent, height = wrapContent){
                    bottomMargin = dip(8)
                }

                descTextView = textView{}.lparams(width = matchParent, height = wrapContent)
            }
        }

        val items = intent.getParcelableExtra<Item>("EXTRA_ITEM")

        val request = ApiRepository()
        val gson = Gson()
        presenter = MainPresenter(this,request, gson)


        presenter.getLeagueList(items?.id)

        items?.image?.let {
            Picasso.get()
                .load(it)
                .into(logoImageView)
        }

        Log.e("Cek", "${items?.id}")

        name = leagues.component1().toString()
        desc = leagues.component2().toString()

        nameTextView.text = name
        descTextView.text = desc
    }

    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun showLeagueDetail(data: List<Leagues>) {
        leagues.addAll(data)
    }
}
