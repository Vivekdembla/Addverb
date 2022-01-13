package com.security.addverb.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.security.addverb.Dao.CountryDao
import com.security.addverb.Model.CountryRoom

@Database(entities = [CountryRoom::class],version = 1, exportSchema = false)
abstract class CountryDataBase : RoomDatabase() {
    abstract fun getCountryDao() : CountryDao
    companion object{
        @Volatile
        private var INSTANCE : CountryDataBase? = null
        fun getDatabase(context: Context) : CountryDataBase{
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, CountryDataBase::class.java,
                    "country_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}