package com.security.addverb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.security.addverb.Adapter.CountryItemClicked
import com.security.addverb.Adapter.CountryListAdapter
import com.security.addverb.Dao.CountryDao
import com.security.addverb.Database.CountryDataBase
import com.security.addverb.Interface.RetrofitService
import com.security.addverb.Model.*
import com.security.addverb.Repository.CountryRepository
import com.security.addverb.ViewModel.CountryViewModel

class MainActivity : AppCompatActivity(), CountryItemClicked {
    lateinit var madapter : CountryListAdapter
    lateinit var viewModel: CountryViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val countryDao :CountryDao = CountryDataBase.getDatabase(application).getCountryDao()
        val repository = CountryRepository(RetrofitService.getInstance(),countryDao)
        viewModel = CountryViewModel(repository,application)
        madapter = CountryListAdapter(this)
        val recycler_view = findViewById<RecyclerView>(R.id.recycler_view)
        viewModel.countryList.observe(this, {
                madapter.updateData(it as ArrayList<CountiesItem>)
            if(viewModel.fetched){
                viewModel.deleteAll()
                for(i in it){
                    val countryRoom = CountryRoom("${ i.name!!.common }\n${i.subregion}\n${i.region}")
                    var s = ""
                    if(i.borders !=null){
                        if(i.borders.isNotEmpty()){
                            for (index in i.borders){
                                s += "$index, "
                            }
                        }

                    }

                    countryRoom.borders = s
                    s=""
                    if(i.capital !=null){
                        if(i.capital.isNotEmpty()) {
                            for (index in i.capital) {
                                s += "$index, "
                            }
                        }
                    }

                    countryRoom.capital = s
                    countryRoom.language = ReturnLanguage(i.languages!!)
                    countryRoom.population = i.population?.toString()
                    countryRoom.flag = i.flags?.png
                    viewModel.insert(countryRoom)
            }

                }
            }
        )
        viewModel.error.observe(this,{
            Log.e("Checking",it.toString())
            }
        )
        viewModel.getAllCountries()
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = madapter
    }

    fun delete_button(view: android.view.View) {
        madapter.clear()
        viewModel.deleteAll()
        Toast.makeText(this,"All Items Deleted Successfully",Toast.LENGTH_LONG).show()
    }
}