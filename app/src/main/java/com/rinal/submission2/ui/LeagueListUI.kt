package com.rinal.submission2.ui

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
                layoutParams = LinearLayout.LayoutParams(250,250)
                scaleType = ImageView.ScaleType.FIT_XY
            }

            textView {
                id = name_league
                layoutParams = LinearLayout.LayoutParams(matchParent, wrapContent)
                textColor = Color.BLACK
                leftPadding = dip(16)
            }.lparams{
                topMargin = dip(8)
            }
        }
    }
}