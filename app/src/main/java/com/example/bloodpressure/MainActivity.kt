package com.example.bloodpressure

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //supportActionBar!!.hide() //關閉標題列



        //跳至填寫頁面
        card1.setOnClickListener {
            val intent = Intent(this@MainActivity, write::class.java)
            startActivity(intent)
        }

        //跳至記錄頁面
        card2.setOnClickListener {
            val intent = Intent(this@MainActivity, history::class.java)
            startActivity(intent)
        }

        //跳至醫生頁面
        card3.setOnClickListener {
            val intent = Intent(this@MainActivity, doctor::class.java)
            startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.option_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.menu_about -> {
                val intent = Intent(this@MainActivity, about_as::class.java)
                startActivity(intent)
                return true
            }
            R.id.use -> {
                val intent = Intent(this@MainActivity, use::class.java)
                startActivity(intent)
                return true
            }
            R.id.work -> {
                val intent = Intent(this@MainActivity, work::class.java)
                startActivity(intent)
                return true
            }
            R.id.exit -> {
                android.os.Process.killProcess(android.os.Process.myPid())
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}