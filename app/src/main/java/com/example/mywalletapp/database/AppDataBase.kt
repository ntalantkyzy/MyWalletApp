package com.example.mywalletapp.database
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mywalletapp.dao.CategoryDao
import com.example.mywalletapp.dao.PaymentsDao
import com.example.mywalletapp.dao.ServicesDao
import com.example.mywalletapp.entities.Category
import com.example.mywalletapp.entities.Payments
import com.example.mywalletapp.entities.Services

@Database(entities = [Services::class, Category::class, Payments::class], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CategoryDao(): CategoryDao
    abstract fun ServicesDao(): ServicesDao
    abstract fun PaymentsDao(): PaymentsDao
}
