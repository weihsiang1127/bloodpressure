package com.example.bloodpressure

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class about_as : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_as)
        supportActionBar!!.hide() //關閉標題列
    }

    fun home(view: View) {
        finish()
    }
}