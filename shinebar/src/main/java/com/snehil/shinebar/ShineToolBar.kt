package com.snehil.shinebar

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.appbar.MaterialToolbar
import com.snehil.shinebar.Utils.getStatusBarHeight
import kotlin.math.roundToInt

class ShineToolBar : MaterialToolbar {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        setPadding(paddingLeft,
            ((paddingTop + getStatusBarHeight(resources)).roundToInt()),
            paddingRight, paddingBottom)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth,
            (measuredHeight + getStatusBarHeight(resources)).roundToInt()
        )
    }
}