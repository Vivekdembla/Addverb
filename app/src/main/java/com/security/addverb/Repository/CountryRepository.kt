package com.security.addverb.Repository

import androidx.lifecycle.LiveData
import com.security.addverb.Dao.CountryDao
import com.security.addverb.Interface.RetrofitService
import com.security.addverb.Model.CountiesItem
import com.security.addverb.Model.CountryRoom

class CountryRepository constructor(private val retrofitService: RetrofitService,
                                    private val countryDao: CountryDao) {

    fun getAllCountries() = retrofitService.getAllCountries()
    fun getAllCountriesFromRoom() :
            List<CountryRoom> = countryDao.getCountries()
    fun insert(countryRoom: CountryRoom){
        countryDao.insertCountry(countryRoom)
    }
    fun deleteAll(){
        countryDao.deleteCountries()
    }
}