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
import android.text.format.DateFormat
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_write.*
import java.util.*
import kotlin.collections.ArrayList


class write : AppCompatActivity() {
    //建立MyDBHelper物件
    private  lateinit var dbrw: SQLiteDatabase

    private var items: ArrayList<String> = ArrayList()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)
        supportActionBar!!.hide() //關閉標題列

        //震動變數
        var myVibrator = application.getSystemService(Service.VIBRATOR_SERVICE) as Vibrator

        //取得目前時間
        //CharSequence s = DateFormat.format("yyyy-MM-dd kk:mm:ss", mCal.getTime());    // kk:24小時制, hh:12小時制
        val mCal = Calendar.getInstance()
        val s = DateFormat.format("yyyy-MM-dd", mCal.time)
        txt_day.setText(s)

        //設定天氣下拉式選單
        val weather = findViewById<View>(R.id.weather) as Spinner
        val w = arrayOf("晴天", "陰天", "雨天")
        val weatherList = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item, w
        )
        weather.adapter = weatherList

        //設定氣溫下拉式選單
        val temperature = findViewById<View>(R.id.temperature) as Spinner
        val t = arrayOf("適中", "炎熱", "寒冷")
        val temperatureList = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item, t
        )
        temperature.adapter = temperatureList

        //設定地點下拉式選單
        val location = findViewById<View>(R.id.location) as Spinner
        val l = arrayOf("家中", "醫院")
        val locationList = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item, l
        )
        location.adapter = locationList

        //檢查輸入的血壓
        big_n.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                if (java.lang.String.valueOf(s) !="" ){
                    val getVal = java.lang.String.valueOf(s).toInt()
                    if ( getVal >= 140 ){
                        big_n.setTextColor(Color.parseColor("#FF3333"));
                        //震動
                        if (Build.VERSION.SDK_INT >= 26) {
                            myVibrator?.vibrate(VibrationEffect.createOneShot(100, 10));
                        } else {
                            myVibrator?.vibrate(100);
                        }
                        //聲音
                        var mediaPlayer: MediaPlayer = MediaPlayer()
                        MediaPlayer.create(this@write,R.raw.translate_tts)
                        mediaPlayer.start()
                        val t = "收縮壓太高了"
                        TTS(this@write, t)
                    }else if( getVal >= 130 ){
                        big_n.setTextColor(Color.parseColor("#FFCC22"));
                        //震動
                        if (Build.VERSION.SDK_INT >= 26) {
                            myVibrator?.vibrate(VibrationEffect.createOneShot(100, 10));
                        } else {
                            myVibrator?.vibrate(100);
                        }
                        //聲音
                        var mediaPlayer: MediaPlayer = MediaPlayer()
                        MediaPlayer.create(this@write,R.raw.translate_tts2)
                        mediaPlayer.start()
                        val t = "收縮壓要注意了"
                        TTS(this@write, t)
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
                if (java.lang.String.valueOf(s) !="" ){
                    val getVal = java.lang.String.valueOf(s).toInt()
                    if ( getVal >= 90 ){
                        small_n.setTextColor(Color.parseColor("#FF3333"));
                        //震動
                        if (Build.VERSION.SDK_INT >= 26) {
                            myVibrator?.vibrate(VibrationEffect.createOneShot(100, 10));
                        } else {
                            myVibrator?.vibrate(100);
                        }
                        //聲音
                        var mediaPlayer: MediaPlayer = MediaPlayer()
                        MediaPlayer.create(this@write,R.raw.translate_tts3)
                        mediaPlayer.start()
                        val t = "舒張壓太高了"
                        TTS(this@write, t)
                    }else if( getVal >= 80 ){
                        small_n.setTextColor(Color.parseColor("#FFCC22"));
                        //震動
                        if (Build.VERSION.SDK_INT >= 26) {
                            myVibrator?.vibrate(VibrationEffect.createOneShot(100, 10));
                        } else {
                            myVibrator?.vibrate(100);
                        }
                        //聲音
                        var mediaPlayer: MediaPlayer = MediaPlayer()
                        MediaPlayer.create(this@write,R.raw.translate_tts4)
                        mediaPlayer.start()
                        val t = "舒張壓要注意了"
                        TTS(this@write, t)
                    }else{
                        small_n.setTextColor(Color.parseColor("#33FF33"));
                    }
                }
            }
        })

        //按鈕區
        back.setOnClickListener {
            finish()
        }

        rest.setOnClickListener {
            val s = DateFormat.format("yyyy-MM-dd", mCal.time)
            txt_day.setText(s)
            big_n.setText("")
            small_n.setText("")
            heart_n.setText("")
            weather.setSelection(0)
            temperature.setSelection(0)
            location.setSelection(0)
        }

        save.setOnClickListener {
            //防呆
            if(txt_day.text.isBlank()){
                Toast.makeText(this,"日期未輸入!!",Toast.LENGTH_SHORT).show()
            }else if(big_n.text.isBlank()){
                Toast.makeText(this,"收縮壓未輸入!!",Toast.LENGTH_SHORT).show()
            }else if(small_n.text.isBlank()){
                Toast.makeText(this,"舒張壓未輸入!!",Toast.LENGTH_SHORT).show()
            }else if(heart_n.text.isBlank()){
                Toast.makeText(this,"心跳未輸入!!",Toast.LENGTH_SHORT).show()
            }else{
                //取得資料庫實體
                dbrw = MyDBHelper(this).writableDatabase
                //dbrw.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('1',2,2,2,'1','1','1')")
                try {
                    dbrw.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES(?,?,?,?,?,?,?)",
                            arrayOf<Any?>(s.toString(), big_n.text.toString(), small_n.text.toString(), heart_n.text.toString(), weather.selectedItem.toString(), temperature.selectedItem.toString(), location.selectedItem.toString()))
                    Toast.makeText(this, "新增成功", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@write, history::class.java)
                    startActivity(intent)
                }catch (e: Exception){
                    Toast.makeText(this, "新增失敗", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

}
