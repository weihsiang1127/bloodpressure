package com.example.bloodpressure

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_history.*

class history : AppCompatActivity() {
    //建立MyDBHelper物件
    private  lateinit var dbrw: SQLiteDatabase

    private var items: ArrayList<String> = ArrayList()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        supportActionBar!!.hide() //關閉標題列

        //設定listview
        /*val imgId = arrayListOf(R.drawable.doctor0,R.drawable.doctor2,R.drawable.doctor3,R.drawable.doctor4)
        val Balls = arrayListOf("籃球","足球","棒球","其他")
        val engNames = arrayListOf("a","b","c","d")
        val items1 =ArrayList<Map<String,Any>>()
        for(i in imgId.indices){
            val item = HashMap<String,Any>()
            item["imgLogo"] = imgId[i]
            item["txtName"] = Balls[i]
            item["txtengName"] = engNames[i]
            items1.add(item)
        }
        var adapter1 = SimpleAdapter(this,
            items1,R.layout.mylayout, arrayOf("imgLogo","txtName","txtengName"),
            intArrayOf(R.id.imgLogo,R.id.txtName,R.id.txtengName))
        listview.adapter=adapter1*/

        //取得資料庫實體
        /*dbrw = MyDBHelper(this).writableDatabase
        //宣告Adapter，使用simple_list_item_1 並連結listview
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        listview.adapter = adapter

        val c = dbrw.rawQuery("SELECT * FROM history",null)
        c.moveToFirst()
        items.clear()
        Toast.makeText(this,"共有${c.count}筆資料",Toast.LENGTH_SHORT).show()
        for(i in 0 until c.count){
            //填入顯示內容
            items.add("日期:${c.getString(1)}\n${c.getString(5)}(${c.getString(6)})(${c.getString(7)})\n${c.getString(2)}/${c.getString(3)}mmHg(心跳${c.getString(4)})")
            //移動到下一筆
            c.moveToNext()
        }
        //更新listView內容
        adapter.notifyDataSetChanged()
        //使用完後記得關閉Cursor
        c.close()*/

        //測試區
        //取得資料庫實體
        dbrw = MyDBHelper(this).writableDatabase
        val c = dbrw.rawQuery("SELECT * FROM history", null)
        c.moveToFirst()
        val items1 =ArrayList<Map<String,Any>>()
        items1.clear()
        Toast.makeText(this, "共有${c.count}筆資料", Toast.LENGTH_SHORT).show()
        //備用存圖片資料
        val picture = ArrayList<Any>(c.count)
        //儲存id
        val number = ArrayList<String>(c.count)
        for(i in 0 until c.count){
            //將id存入陣列
            number.add(c.getString(0))
            //填入顯示內容
            val item = HashMap<String,Any>()
            if(c.getString(2).toInt()>=140 && c.getString(3).toInt()>=90 ){
                item["imgLogo"] = R.drawable.alert
            }else if(c.getString(2).toInt()>=130 && c.getString(3).toInt()>=80 ){
                item["imgLogo"] = R.drawable.warning
            }else{
                item["imgLogo"] = R.drawable.good
            }
            item["txtName"] = "日期:${c.getString(1)}"
            item["txtengName"] = "${c.getString(5)}(${c.getString(6)})(${c.getString(7)})\n${c.getString(2)}/${c.getString(3)}mmHg(心跳${c.getString(4)})"
            items1.add(item)
            //移動到下一筆
            c.moveToNext()
        }
        var adapter1 = SimpleAdapter(this,
            items1,R.layout.mylayout, arrayOf("imgLogo","txtName","txtengName"),
            intArrayOf(R.id.imgLogo,R.id.txtName,R.id.txtengName))
        listview.adapter=adapter1
        listview.onItemClickListener = object :
            AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                /*val toast = Toast.makeText(
                    this@history,
                    "你選的是："+number[position], Toast.LENGTH_SHORT
                ) //顯示 Toast
                toast.show()*/
                var bundle = Bundle()
                //設定 bundle 內容
                bundle.putString("id",number[position].toString())

                //新增一個intnet
                val intent = Intent(this@history, update::class.java)

                //把bundle放到intent裡面去
                intent.putExtra("bundle",bundle)
                startActivity(intent)
            }

        }
        //使用完後記得關閉Cursor
        c.close()
        //返回按鈕
        delete.setOnClickListener {
            finish()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        dbrw.close()
    }
}