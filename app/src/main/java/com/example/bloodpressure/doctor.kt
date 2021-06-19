package com.example.bloodpressure

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.SimpleAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_doctor.*

class doctor : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctor)
        supportActionBar!!.hide() //關閉標題列

        //設定listview
        val mTitle = arrayOf("林醫生", "王醫生", "曾醫生", "田醫生", "朱醫生", "廖醫生", "陳醫生", "楊醫生", "郭醫生", "葉醫生")
        val mDescription =
            arrayOf("台北市", "高雄市", "臺南市", "臺中市", "桃園市", "新北市", "基隆市", "新竹市", "苗栗縣", "澎湖縣")
        val imgId = intArrayOf(
            R.drawable.doctor,
            R.drawable.doctor0,
            R.drawable.doctor2,
            R.drawable.doctor3,
            R.drawable.doctor4,
            R.drawable.doctor5,
            R.drawable.doctor6,
            R.drawable.doctor7,
            R.drawable.doctor8,
            R.drawable.doctor9
        )
        val items =ArrayList<Map<String, Any>>()
        for(i in imgId.indices){
            val item = HashMap<String, Any>()
            item["imgLogo"] = imgId[i]
            item["txtName"] = mTitle[i]
            item["txtengName"] = mDescription[i]
            items.add(item)
        }
        var adapter = SimpleAdapter(
            this,
            items, R.layout.row, arrayOf("imgLogo", "txtName", "txtengName"),
            intArrayOf(R.id.imgLogo, R.id.txtName, R.id.txtengName)
        )

        listview.adapter=adapter

        listview.onItemClickListener = object :
            AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                if(position == 0){
                    val uri= Uri.parse("tel:0900000000")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }else if(position == 1){
                    val uri= Uri.parse("tel:0911111111")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }else if(position == 2){
                    val uri= Uri.parse("tel:0922222222")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }else if(position == 3){
                    val uri= Uri.parse("tel:0933333333")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }else if(position == 4){
                    val uri= Uri.parse("tel:0944444444")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }else if(position == 5){
                    val uri= Uri.parse("tel:0955555555")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }else if(position == 6){
                    val uri= Uri.parse("tel:0966666666")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }else if(position == 7){
                    val uri= Uri.parse("tel:0977777777")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }else if(position == 8){
                    val uri= Uri.parse("tel:0988888888")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }else if(position == 9){
                    val uri= Uri.parse("tel:0999999999")
                    val intent = Intent(Intent.ACTION_VIEW,uri)
                    startActivity(intent)
                }
            }

        }
        //返回按鈕
        delete.setOnClickListener {
            finish()
        }
    }
}