package com.security.addverb.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.security.addverb.Model.CountiesItem
import com.security.addverb.Model.CountryRoom

@Dao
public interface CountryDao{
    @Query("Select * from Country")
    fun getCountries() : List<CountryRoom>

    @Insert
    fun insertCountry(country : CountryRoom)

    @Query("DELETE from Country")
    fun deleteCountries()
}