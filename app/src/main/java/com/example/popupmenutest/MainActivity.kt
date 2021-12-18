package com.example.popupmenutest

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickBtn = findViewById<Button>(R.id.clickBtn)
        clickBtn.setOnLongClickListener {

            val popupMenu = PopupMenu(this, clickBtn)
            popupMenu.menuInflater.inflate(R.menu.my_popup_menu, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener(object : PopupMenu.OnMenuItemClickListener {
                override fun onMenuItemClick(item: MenuItem?): Boolean {
                    Toast.makeText(this@MainActivity, item?.title, Toast.LENGTH_SHORT).show()
                    return true
                }
            })

            popupMenu.show()
            return@setOnLongClickListener true
        }
    }
}