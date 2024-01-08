package com.example.ditingsmarttravel

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class TripFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fabTrip = view.findViewById<FloatingActionButton>(R.id.fab_trip)
        fabTrip.setOnClickListener {
            activity?.let {
                // 创建用于启动CreateActivity的Intent
                val intent = Intent(it, CreateActivity::class.java)
                // 开始新的Activity
                it.startActivity(intent)
            }
        }

        val greetingTextView = view.findViewById<TextView>(R.id.text_greeting)
        val currentTime = getCurrentTime()
        val greeting = getGreeting(currentTime)
        greetingTextView.text = greeting
    }

    private fun getCurrentTime(): Date {
        return Calendar.getInstance().time
    }

    private fun getGreeting(currentTime: Date): String {
        val format = SimpleDateFormat("HH:mm", Locale.getDefault())
        val time = format.format(currentTime)
        return when {
            "05:00" <= time && time < "08:00" -> "早上好"
            "08:01" <= time && time < "12:00" -> "上午好"
            "12:01" <= time && time < "14:00" -> "中午好"
            "14:01" <= time && time < "19:00" -> "下午好"
            else -> "晚上好"
        }
    }
}