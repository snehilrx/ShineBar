package com.snehil.shinebar.demo

import android.content.res.Resources
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.cardview.widget.CardView
import androidx.core.view.setMargins
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter


class GradientAdapter(
    private val colors: List<Pair<Int, Int>>,
    fa: FragmentActivity
) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int = colors.size

    override fun createFragment(position: Int): Fragment {
        return ColorFrag().apply {
            color = colors[position]
        }
    }

}

class ColorFrag() :
    Fragment() {

    lateinit var color: Pair<Int, Int>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        savedInstanceState?.let { safe ->
            val intArray = safe.getIntArray("color")
            color = Pair(intArray?.get(0) ?: 0, intArray?.get(1) ?: 0)
        }
        context?.let { context ->
            val cardView = CardView(context).apply {
                layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT).apply {
                    this.setMargins(16.dp)
                }
                radius = 24.dp.toFloat()
            }
            val view = View(context).apply {
                layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            }
            cardView.addView(view)
            view.background = GradientDrawable(
                        GradientDrawable.Orientation.TOP_BOTTOM,
                        intArrayOf(color.first, color.second))
            return cardView
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putIntArray("color", intArrayOf(color.first, color.second))
        super.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.let { safe ->
            val intArray = safe.getIntArray("color")
            color = Pair(intArray?.get(0) ?: 0, intArray?.get(1) ?: 0)
        }
    }
}

val Int.dp: Int
    get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()