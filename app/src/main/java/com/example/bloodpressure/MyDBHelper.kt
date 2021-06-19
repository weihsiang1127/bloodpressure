package com.example.bloodpressure

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper (context: Context, name: String = database, factory:
SQLiteDatabase.CursorFactory? = null, version: Int = v):
SQLiteOpenHelper(context, name , factory, version) {
    companion object {
        private const val database ="mdatabase.db"  //資料庫名稱
        private const val v = 1                     //資料庫版本
    }

    override fun onCreate(db: SQLiteDatabase) {
        //需要加入建立資料表的SQL語法
        db.execSQL("CREATE TABLE history(id integer primary key, date text, n1 integer, n2 integer, heart integer, weather text, temperature text, location text)")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-01',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-02',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-03',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-04',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-05',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-06',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-07',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-08',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-09',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-10',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-11',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-12',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-13',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-14',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-15',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-16',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-17',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-18',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-19',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-20',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-21',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-22',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-23',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-24',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-25',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-26',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-27',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-28',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-29',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-04-30',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-01',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-02',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-03',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-04',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-05',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-06',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-07',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-08',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-09',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-10',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-11',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-12',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-13',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-14',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-15',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-16',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-17',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-18',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-19',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-20',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-21',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-22',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-23',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-24',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-25',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-26',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-27',140,90,80,'雨天','寒冷','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-28',120,70,80,'晴天','炎熱','家中')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-29',130,80,80,'陰天','適中','醫院')")
        db.execSQL("INSERT INTO history(date,n1,n2,heart,weather,temperature,location) VALUES('2021-05-30',140,90,80,'雨天','寒冷','家中')")
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        //需要加入刪除資料表的SQL語法
        db.execSQL("DROP TABLE IF EXISTS history")
        onCreate(db)
    }
}