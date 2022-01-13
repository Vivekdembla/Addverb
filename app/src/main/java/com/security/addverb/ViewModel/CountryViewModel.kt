package com.security.addverb.ViewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.security.addverb.Model.*
import com.security.addverb.Repository.CountryRepository
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryViewModel constructor(private val repository: CountryRepository, application: Application)  : AndroidViewModel(application)  {
    var countryList = MutableLiveData<List<CountiesItem>>()
    val error = MutableLiveData<String>()
    var fetched:Boolean = false

    @DelicateCoroutinesApi
    fun getAllCountries(){

        val response = repository.getAllCountries()
        response.enqueue(object : Callback<List<CountiesItem>>{
            override fun onResponse(call: Call<List<CountiesItem>>, response: Response<List<CountiesItem>>) {
                countryList.postValue(response.body())
                fetched = true
                Log.e("Checking",countryList.toString())
            }

            override fun onFailure(call: Call<List<CountiesItem>>, t: Throwable) {
                fetched = false
                GlobalScope.launch(Dispatchers.IO) {
                    val countryRoomData = repository.getAllCountriesFromRoom()
                    withContext(Dispatchers.Main){
                        val allcountries = ArrayList<CountiesItem>()
                        for(index in countryRoomData){
                            val name = Name("${index.name}\n" +
                                    "${index.subregion}\n" +
                                    "${index.region}", NativeName(Zho("")),"")

                            val borders = ArrayList<String>()
                            borders.add(index.borders.toString())

                            val capital = ArrayList<String>()
                            capital.add(index.capital.toString())

                            val currency = Currencies(CNY(index.currency.toString(),""))

                            val flags = Flags(index.flag.toString(),"")

                            val languages = Languages(index.language.toString())
                            val population :Int = index.population!!.toInt()

                            val region = index.region

                            val subregion = index.subregion

                            var countryItem : CountiesItem = CountiesItem(borders,capital,currency,flags,
                                languages,name,population,region,subregion)

                            allcountries.add(countryItem)

                        }
                        countryList.postValue(allcountries)
                    }
                }

            }

        })
    }
    @DelicateCoroutinesApi
    fun deleteAll() = GlobalScope.launch (Dispatchers.IO){
        repository.deleteAll()
    }
    @DelicateCoroutinesApi
    fun insert(countryRoom: CountryRoom) = GlobalScope.launch (Dispatchers.IO){
        repository.insert(countryRoom)
    }
}