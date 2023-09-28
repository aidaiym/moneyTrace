package com.example.moneytrace

import android.app.Application

class MainApplication : Application() {
    val database by lazy { AppDatabase.createDataBase(this)}

}