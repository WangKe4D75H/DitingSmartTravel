package com.example.ditingsmarttravel

import android.animation.ValueAnimator
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.marginBottom

class ThemeActivity : AppCompatActivity() {
    private val rectangles = mutableListOf<View>()// 保存所有的矩形View
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.icon_left_arrow)
        setSupportActionBar(toolbar)
        val upArrow: Drawable? = ContextCompat.getDrawable(applicationContext,
            R.drawable.icon_left_arrow)
        upArrow?.setColorFilter(
            ContextCompat.getColor(applicationContext, R.color.ditingBlue),
            PorterDuff.Mode.SRC_ATOP)
        supportActionBar?.setHomeAsUpIndicator(upArrow)
        toolbar.setNavigationOnClickListener { onBackPressed() }


        // 获取到我们在XML定义的LinearLayout
        val layout = findViewById<LinearLayout>(R.id.layout)

        // 循环创建矩形View并添加到LinearLayout中
        for (i in 1..6) {
            val rectangleText = when(i) {
                1 -> "谛听蓝"
                2 -> "林海"
                3 -> "藤萝"
                4 -> "海棠"
                5 -> "银杏"
                else -> "丹霞"
            }
            val rectangle = VerticalTextView(this).apply {
                layoutParams = LinearLayout.LayoutParams(dpToPx(40f), dpToPx(150f))
                setBackgroundColor(ContextCompat.getColor(context, resources.getIdentifier
                    ("rectangle$i", "color", packageName)))
                // 将文本设置为矩形的名字
                text = rectangleText
                // 设置字体大小适当
                setTextSize(16f)
                // 设置文本位置为右下角
                gravity = Gravity.BOTTOM or Gravity.END
                setPadding(5,5,5,5)
                setTextColor(getColor(R.color.white))
                // 点击事件
                setOnClickListener {
                    select(it)
                }
            }
            rectangles.add(rectangle)
            layout.addView(rectangle)
        }
    }

    // 选中矩形，改变宽度
    private fun select(view: View) {
        rectangles.forEach { rectangle ->
            val isCurrent = rectangle == view
            val toWidth = if (isCurrent) dpToPx(120f) else dpToPx(40f)

            ValueAnimator.ofInt(rectangle.width, toWidth).apply {
                duration = 300
                addUpdateListener {
                    val params = rectangle.layoutParams
                    params.width = it.animatedValue as Int
                    rectangle.layoutParams = params
                }
                start()
            }
        }
    }

    // dp 转 px
    private fun dpToPx(dp: Float): Int {
        val density = resources.displayMetrics.density
        return (dp * density + 0.5f).toInt()
    }
}