package com.security.addverb.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.security.addverb.Model.CountiesItem
import com.security.addverb.R
import com.security.addverb.ReturnLanguage

class CountryListAdapter(private val listener:CountryItemClicked) : RecyclerView.Adapter<CountryViewHolder>() {

    val countries : ArrayList<CountiesItem> = ArrayList()

    fun clear(){
        countries.clear()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        val viewHolder = CountryViewHolder(view)
        view.setOnClickListener {
            Toast.makeText(parent.context,"Item Clicked",Toast.LENGTH_LONG).show()
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        var s = ""
        if(countries[position].borders !=null){
            if(countries[position].borders!!.isNotEmpty()){
                for (i in countries[position].borders!!){
                        s += "$i ,"
                }
            }

        }

        holder.border.text = s
        s=""
        if(countries[position].capital !=null){
            if(countries[position].capital!!.isNotEmpty()) {
                for (i in countries[position].capital!!) {
                    s += "$i "
                }
            }
        }

        holder.capital.text = s
        holder.country_name.text = "${countries[position].name?.common}\n${countries[position].subregion}" +
                "\n${countries[position].region}"
        holder.languages.text = ReturnLanguage(countries[position].languages!!)
        holder.population.text = countries[position].population?.toString()
        Glide.with(holder.itemView.context).load(countries[position].flags?.png).into(holder.country_image)

    }

    override fun getItemCount(): Int {
        return countries.size
    }
    fun updateData(list : ArrayList<CountiesItem>){
        countries.addAll(list)
        notifyDataSetChanged()
    }

}

class CountryViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    val country_name = itemView.findViewById<TextView>(R.id.country_name)
    val country_image = itemView.findViewById<ImageView>(R.id.flag_image)
    val border = itemView.findViewById<TextView>(R.id.borders)
    val capital = itemView.findViewById<TextView>(R.id.capital)
    val population = itemView.findViewById<TextView>(R.id.population)
    val languages = itemView.findViewById<TextView>(R.id.languages)
}


interface CountryItemClicked {

}
