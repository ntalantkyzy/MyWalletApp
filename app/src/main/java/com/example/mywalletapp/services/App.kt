package com.example.mywalletapp.services

import android.app.Application
import androidx.room.Room
import com.example.mywalletapp.database.AppDatabase

class App : Application() {
    private var database: AppDatabase? = null

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .allowMainThreadQueries().build()
    }

    fun getDatabase(): AppDatabase? {
        return database
    }

    companion object{
        var instance: App? = null
    }
}