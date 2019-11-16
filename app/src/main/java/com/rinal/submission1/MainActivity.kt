package com.rinal.submission1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()

    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        relativeLayout {
            padding = dip(16)

            recyclerView {
                lparams(matchParent, matchParent)

                layoutManager = LinearLayoutManager(context)

                adapter = ItemAdapter(items) {
                    Toast.makeText(applicationContext, it.name, Toast.LENGTH_SHORT).show()
                    startActivity<DetailActivity>("EXTRA_ITEM" to it)
                }
            }
        }


        val name = resources.getStringArray(R.array.name_league)
        val image = resources.obtainTypedArray(R.array.img_league)
        val description = resources.getStringArray(R.array.desc_league)
        val id = resources.getStringArray(R.array.idLeague)
        items.clear()

        for (i in name.indices){
            items.add(Item(id[i],
                name[i],
                image.getResourceId(i,0),
                description[i]))
        }


        image.recycle()

        supportActionBar?.setTitle("League List")
    }
}

