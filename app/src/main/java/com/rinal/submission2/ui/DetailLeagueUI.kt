package com.rinal.submission2.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.google.android.material.tabs.TabLayout
import com.rinal.submission2.leagues.DetailLeagues
import com.rinal.submission2.R.color.colorPrimary
import org.jetbrains.anko.*
import org.jetbrains.anko.design.tabLayout
import org.jetbrains.anko.support.v4.viewPager

class DetailLeagueUI : AnkoComponent<DetailLeagues> {

    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var logoImageView : ImageView

        @SuppressLint("StaticFieldLeak")
        lateinit var nameTextView : TextView

        @SuppressLint("StaticFieldLeak")
        lateinit var descTextView : TextView

        @SuppressLint("StaticFieldLeak")
        lateinit var progressBar: ProgressBar

        lateinit var tabLayout: TabLayout

        var viewPagerLayout = 1
    }

    @SuppressLint("WrongConstant", "ResourceAsColor")
    override fun createView(ui: AnkoContext<DetailLeagues>) = with(ui) {

        verticalLayout {
            lparams(matchParent, matchParent)

            scrollView {
                lparams(matchParent, dip(400))
                backgroundColorResource = colorPrimary

                relativeLayout {
                    lparams(matchParent, wrapContent)
                    padding = dip(16)

                    verticalLayout{
                        lparams {
                            leftMargin = dip(8)
                            rightMargin = dip(8)
                        }

                        logoImageView = imageView {
                            scaleType = ImageView.ScaleType.FIT_XY
                        }.lparams(width = matchParent, height = dip(300)) {
                            bottomMargin = dip(16)
                        }

                        nameTextView = textView {
                            textColor = Color.BLACK
                        }.lparams(width = matchParent, height = wrapContent) {
                            bottomMargin = dip(8)
                        }

                        descTextView = textView {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                justificationMode = Context.BIND_ADJUST_WITH_ACTIVITY
                            }
                            textColor = Color.BLACK
                        }.lparams(width = matchParent, height = wrapContent)
                    }

                    progressBar = progressBar ().lparams{
                        centerInParent()
                    }
                }
            }

            tabLayout = tabLayout {
                lparams {
                    width = matchParent
                    height = wrapContent
                }
                tabMode = TabLayout.MODE_FIXED
                backgroundColorResource = colorPrimary
            }

            viewPager {
                id = viewPagerLayout
                lparams {
                    width = matchParent
                    height = wrapContent
                }
            }
        }
    }
}

