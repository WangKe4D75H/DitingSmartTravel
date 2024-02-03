package com.example.ditingsmarttravel

import android.annotation.SuppressLint
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat

class HistoryActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
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

    }
}