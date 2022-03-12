package com.example.mywalletapp.dao
import androidx.room.*
import com.example.mywalletapp.entities.Services

@Dao
interface ServicesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addServices(vararg services: Services)

    @Query("SELECT * FROM Services")
    fun getAllServices(): Array<Services>

    @Delete
    fun deleteServices(services: Services)
}
