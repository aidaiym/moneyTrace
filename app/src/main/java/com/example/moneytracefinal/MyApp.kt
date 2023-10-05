package com.example.moneytracefinal

import android.app.Application
import com.example.moneytracefinal.data.MainDb

class MyApp : Application() {
    val database by lazy { MainDb.createDataBase(this)}
}