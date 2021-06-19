package com.example.bloodpressure

import android.app.Service
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_update.*
import kotlinx.android.synthetic.main.activity_update.back
import kotlinx.android.synthetic.main.activity_update.big_n
import kotlinx.android.synthetic.main.activity_update.heart_n
import kotlinx.android.synthetic.main.activity_update.rest
import kotlinx.android.synthetic.main.activity_update.save
import kotlinx.android.synthetic.main.activity_update.small_n
import kotlinx.android.synthetic.main.activity_update.txt_day
import kotlinx.android.synthetic.main.activity_write.*
import java.util.*
import kotlin.collections.ArrayList


class update : AppCompatActivity() {
    //建立MyDBHelper物件
    private  lateinit var dbrw: SQLiteDatabase

    private var items: ArrayList<String> = ArrayList()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        supportActionBar!!.hide() //關閉標題列

        //震動變數
        var myVibrator = application.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator

        //抓history傳過來要修改的編號
        val id = intent.getBundleExtra("bundle")?.getString("id")!!
        //Toast.makeText(this, id, Toast.LENGTH_SHORT).show()

        //取得資料庫實體
        dbrw = MyDBHelper(this).writableDatabase
        val c = dbrw.rawQuery("SELECT * FROM history WHERE id=${id}", null)
        c.moveToFirst()

        txt_day.setText(c.getString(1))
        big_n.setText(c.getString(2))
        if (c.getString(2).toInt() >= 140) {
            big_n.setTextColor(Color.parseColor("#FF3333"));
        } else if (c.getString(2).toInt() >= 130) {
            big_n.setTextColor(Color.parseColor("#FFCC22"));
        }else{
            big_n.setTextColor(Color.parseColor("#33FF33"));
        }
        small_n.setText(c.getString(3))
        if (c.getString(3).toInt() >= 90) {
            small_n.setTextColor(Color.parseColor("#FF3333"));
        } else if (c.getString(3).toInt() >= 80) {
            small_n.setTextColor(Color.parseColor("#FFCC22"));
        }else{
            small_n.setTextColor(Color.parseColor("#33FF33"));
        }
        heart_n.setText(c.getString(4))

        //設定天氣下拉式選單
        val weather = findViewById<View>(R.id.weather) as Spinner
        val w = arrayOf("晴天", "陰天", "雨天")
        val weatherList = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item, w
        )
        weather.adapter = weatherList
        for(i in w.indices){
            if(c.getString(5).equals(w[i])){
                weather.setSelection(i)

            }
        }

        //設定氣溫下拉式選單
        val temperature = findViewById<View>(R.id.temperature) as Spinner
        val t = arrayOf("適中", "炎熱", "寒冷")
        val temperatureList = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item, t
        )
        temperature.adapter = temperatureList
        for(i in t.indices){
            if(c.getString(6).equals(t[i])){
                temperature.setSelection(i)

            }
        }

        //設定地點下拉式選單
        val location = findViewById<View>(R.id.location) as Spinner
        val l = arrayOf("家中", "醫院")
        val locationList = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item, l
        )
        location.adapter = locationList
        for(i in l.indices){
            if(c.getString(7).equals(l[i])){
                location.setSelection(i)

            }
        }

        //檢查輸入的血壓
        big_n.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (java.lang.String.valueOf(s) != "") {
                    val getVal = java.lang.String.valueOf(s).toInt()
                    if (getVal >= 140) {
                        big_n.setTextColor(Color.parseColor("#FF3333"));
                        //震動
                        if (Build.VERSION.SDK_INT >= 26) {
                            myVibrator?.vibrate(VibrationEffect.createOneShot(100, 10));
                        } else {
                            myVibrator?.vibrate(100);
                        }
                        //聲音
                        var mediaPlayer: MediaPlayer = MediaPlayer()
                        MediaPlayer.create(this@update,R.raw.translate_tts)
                        mediaPlayer.start()
                        val t = "收縮壓太高了"
                        TTS(this@update, t)
                    } else if (getVal >= 130) {
                        big_n.setTextColor(Color.parseColor("#FFCC22"));
                        //震動
                        if (Build.VERSION.SDK_INT >= 26) {
                            myVibrator?.vibrate(VibrationEffect.createOneShot(100, 10));
                        } else {
                            myVibrator?.vibrate(100);
                        }
                        //聲音
                        var mediaPlayer: MediaPlayer = MediaPlayer()
                        MediaPlayer.create(this@update,R.raw.translate_tts2)
                        mediaPlayer.start()
                        val t = "收縮壓要注意了"
                        TTS(this@update, t)
                    }else{
                        big_n.setTextColor(Color.parseColor("#33FF33"));
                    }
                }

            }
        })
        small_n.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (java.lang.String.valueOf(s) != "") {
                    val getVal = java.lang.String.valueOf(s).toInt()
                    if (getVal >= 90) {
                        small_n.setTextColor(Color.parseColor("#FF3333"));
                        //震動
                        if (Build.VERSION.SDK_INT >= 26) {
                            myVibrator?.vibrate(VibrationEffect.createOneShot(100, 10));
                        } else {
                            myVibrator?.vibrate(100);
                        }
                        //聲音
                        var mediaPlayer: MediaPlayer = MediaPlayer()
                        MediaPlayer.create(this@update,R.raw.translate_tts3)
                        mediaPlayer.start()
                        val t = "舒張壓太高了"
                        TTS(this@update, t)
                    } else if (getVal >= 80) {
                        small_n.setTextColor(Color.parseColor("#FFCC22"));
                        //震動
                        if (Build.VERSION.SDK_INT >= 26) {
                            myVibrator?.vibrate(VibrationEffect.createOneShot(100, 10));
                        } else {
                            myVibrator?.vibrate(100);
                        }
                        //聲音
                        var mediaPlayer: MediaPlayer = MediaPlayer()
                        MediaPlayer.create(this@update,R.raw.translate_tts4)
                        mediaPlayer.start()
                        val t = "舒張壓要注意了"
                        TTS(this@update, t)
                    }else{
                        small_n.setTextColor(Color.parseColor("#33FF33"));
                    }
                }
            }
        })

        //按鈕區
        rest.setOnClickListener {
            txt_day.setText(c.getString(1))
            big_n.setText(c.getString(2))
            small_n.setText(c.getString(3))
            heart_n.setText(c.getString(4))
            for(i in w.indices){
                if(c.getString(5).equals(w[i])){
                    weather.setSelection(i)

                }
            }
            for(i in t.indices){
                if(c.getString(6).equals(t[i])){
                    temperature.setSelection(i)

                }
            }
            for(i in l.indices){
                if(c.getString(7).equals(l[i])){
                    location.setSelection(i)

                }
            }
        }

        delete.setOnClickListener {
            try {
                dbrw.execSQL("DELETE FROM history WHERE id=?",
                        arrayOf<Any?>(id.toString()))
                Toast.makeText(this, "刪除成功", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@update, history::class.java)
                startActivity(intent)
            }catch (e: Exception){
                Toast.makeText(this, "刪除失敗", Toast.LENGTH_SHORT).show()
            }
        }

        save.setOnClickListener {
            if(txt_day.text.isBlank()){
                Toast.makeText(this,"日期未輸入!!",Toast.LENGTH_SHORT).show()
            }else if(big_n.text.isBlank()){
                Toast.makeText(this,"收縮壓未輸入!!",Toast.LENGTH_SHORT).show()
            }else if(small_n.text.isBlank()){
                Toast.makeText(this,"舒張壓未輸入!!",Toast.LENGTH_SHORT).show()
            }else if(heart_n.text.isBlank()){
                Toast.makeText(this,"心跳未輸入!!",Toast.LENGTH_SHORT).show()
            }else{
                try {
                    dbrw.execSQL("UPDATE history SET date=?,n1=?,n2=?,heart=?,weather=?,temperature=?,location=? WHERE id=?",
                            arrayOf<Any?>(txt_day.text.toString(), big_n.text.toString(), small_n.text.toString(), heart_n.text.toString(), weather.selectedItem.toString(), temperature.selectedItem.toString(), location.selectedItem.toString(), id.toString()))
                    Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@update, history::class.java)
                    startActivity(intent)
                }catch (e: Exception){
                    Toast.makeText(this, "修改失敗", Toast.LENGTH_SHORT).show()
                }
            }
        }

        back.setOnClickListener {
            finish()
        }
    }

}