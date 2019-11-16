package com.rinal.submission1

import android.graphics.Color
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import org.jetbrains.anko.*

class LeagueListUI : AnkoComponent<ViewGroup>{

    companion object {
        val img_league = 1
        val name_league = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {

            lparams(matchParent, wrapContent){
                bottomMargin = dip(8)
            }
            orientation = LinearLayout.HORIZONTAL

            imageView{
                id = img_league
                layoutParams = LinearLayout.LayoutParams(200,200)
                scaleType = ImageView.ScaleType.FIT_XY
            }

            textView {
                id = name_league
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                textColor = Color.BLACK
                allCaps = true
            }.lparams{
                topMargin = dip(4)
                leftMargin = dip(16)
            }
        }
    }
}