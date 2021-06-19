package com.example.bloodpressure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class use : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_use)
        supportActionBar!!.hide() //關閉標題列
    }

    fun home(view: View) {
        finish()
    }
}