package com.rinal.submission2.ui

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import com.rinal.submission2.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class MatchListUI : AnkoComponent<ViewGroup> {

    companion object {
        val name_home = 1
        val name_away = 2
        val date_match = 3
        val img_home = 4
        val img_away = 5
        val scor_home = 6
        val scor_away = 7
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        verticalLayout {
            lparams(matchParent, wrapContent)

            cardView {
                lparams{
                    leftMargin = dip(10)
                    rightMargin = dip(10)
                    topMargin = dip(10)
                    bottomMargin = dip(10)
                    width = matchParent
                    height = wrapContent
                    padding = dip(10)
                }
                backgroundColor = R.color.colorCostum
                background = GradientDrawable().apply {
                    shape = GradientDrawable.RECTANGLE
                    cornerRadius = 8f
                    setStroke(2, Color.GRAY)
                }


                verticalLayout {
                    lparams(matchParent, wrapContent)
                    orientation = LinearLayout.VERTICAL
                    textView {
                        id = date_match
                        gravity = Gravity.CENTER
                    }.lparams{
                        width = matchParent
                        height =wrapContent
                    }
                }

                verticalLayout {
                    orientation = LinearLayout.HORIZONTAL
                    weightSum = 3f
                    lparams{
                        width = matchParent
                        height = wrapContent
                        topMargin = dip(24)
                        bottomMargin = dip(8)
                    }

                    verticalLayout {
                        lparams{
                            weight = 1f
                            height = wrapContent
                            width = matchParent
                        }

                        textView {
                            id = name_home
                            gravity = Gravity.CENTER
                            textColor = Color.BLACK
                        }.lparams(matchParent, wrapContent)

                        imageView {
                            id = img_home
                        }.lparams {
                            width = dip(100)
                            height = dip(100)
                            gravity = Gravity.CENTER
                        }
                    }

                    verticalLayout {
                        lparams{
                            weight = 1f
                            height = matchParent
                            width = matchParent
                        }
                        orientation = LinearLayout.HORIZONTAL
                        gravity = Gravity.CENTER

                        textView {
                            id = scor_home
                            gravity = Gravity.CENTER
                            text = "0"
                            textColor = Color.BLACK
                            textSize = 30f
                        }.lparams {
                            height = wrapContent
                            width = wrapContent
                            rightMargin = dip(16)
                        }

                        textView {
                            id = scor_away
                            gravity = Gravity.CENTER
                            text = "0"
                            textColor = Color.BLACK
                            textSize = 30f
                        }.lparams {
                            height = wrapContent
                            width = wrapContent
                            leftMargin = dip(16)
                        }
                    }

                    verticalLayout {
                        lparams{
                            weight = 1f
                            height = wrapContent
                            width = matchParent
                        }
                        textView {
                            id = name_away
                            gravity = Gravity.CENTER
                            textColor = Color.BLACK
                        }.lparams(matchParent, wrapContent)

                        imageView {
                            id = img_away
                        }.lparams {
                            width = dip(100)
                            height = dip(100)
                            gravity = Gravity.CENTER
                        }
                    }
                }
            }
        }
    }
}