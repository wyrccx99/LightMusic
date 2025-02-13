package com.brins.lightmusic.ui.customview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.Scroller
import androidx.viewpager.widget.ViewPager

class MainViewPager @JvmOverloads constructor(context: Context, attrs: AttributeSet) : ViewPager(context, attrs) {

    private var isCanScroll = true
    private var mDownPosX = 0f
    private var mDownPosY = 0f
    private var isIntercept = false
    private val minThreshold = 5

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        val x = ev.x
        val y = ev.y
        when (ev.action) {

            MotionEvent.ACTION_DOWN -> {
                mDownPosX = x
                mDownPosY = y

            }
            MotionEvent.ACTION_SCROLL -> {
                val dealtX = Math.abs(x - mDownPosX)
                val dealtY = Math.abs(y - mDownPosY)
                if (dealtX >= dealtY || dealtX >= minThreshold){
                    isIntercept = true
                }
                return isIntercept
            }
        }
        return super.onInterceptTouchEvent(ev)
    }

    fun setIsScanScroll(isCanScroll: Boolean) {
        this.isCanScroll = isCanScroll
    }

    override fun scrollTo(x: Int, y: Int) {
        super.scrollTo(x, y)
    }

    override fun canScroll(v: View, checkV: Boolean, dx: Int, x: Int, y: Int): Boolean {
        if (v.javaClass.name == "com.brins.lightmusic.ui.customview.PileLayout") {
            return true
        }
        return super.canScroll(v, checkV, dx, x, y)
    }
}