package com.example.ditingsmarttravel

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

class MeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_me, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 获取ListView的实例
        val listView = view.findViewById<ListView>(R.id.options_list)

        // 创建一个包含选项的数组
        val options = arrayOf("日间/夜间模式切换", "行程历史", "个人信息", "主题风格", "关于本应用")
        val leftIcons1 = arrayOf(R.drawable.icon_moon_black, R.drawable.icon_history_black,
            R.drawable.icon_user_black, R.drawable.icon_theme_black, R.drawable.icon_about_black)

        // 创建一个填充了选项的ArrayAdapter
        val adapter = IconArrayAdapter(
            requireContext(),
            R.layout.option_item,
            options,
            leftIcons1
            //leftIcons2
        )

        // 将adapter设置给ListView
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, view, position, id ->
            when (position) {
                0 -> { startActivity(Intent(context, DayNightActivity::class.java))}
                1 -> { /* 行程历史处理 */ }
                2 -> { /* 个人信息处理 */ }
                3 -> { /* 主题风格处理 */ }
                4 -> { /* 关于本应用处理 */ }
            }
        }
    }

    class IconArrayAdapter(
        context: Context,
        private val resource: Int,
        private val items: Array<String>,
        private val leftIcons1: Array<Int>,
        //private val leftIcons2: Array<Int>
    ) : ArrayAdapter<String>(context, resource, items) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context).inflate(resource, parent, false)

            val tvOption = view.findViewById<TextView>(R.id.option_title)
            val imgIconLeft1 = view.findViewById<ImageView>(R.id.left_icon1)
            val imgIconRight = view.findViewById<ImageView>(R.id.right_icon)
            imgIconLeft1.setColorFilter(ContextCompat.getColor(context, R.color.ditingBlue),
                android.graphics.PorterDuff.Mode.SRC_IN)
            imgIconRight.setColorFilter(ContextCompat.getColor(context,R.color.ditingBlue),
                android.graphics.PorterDuff.Mode.SRC_IN)

            tvOption.text = items[position]
            imgIconLeft1.setImageResource(leftIcons1[position])

            return view
        }
    }
}