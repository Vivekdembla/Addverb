package com.security.addverb.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Country")
class CountryRoom(
    @PrimaryKey
    var name: String="",
    var borders: String?="",
    var capital: String?="",
    var currency: String?="",
    var flag: String?="",
    var language: String?="",
    var population: String?="",
    var region: String?="",
    var subregion: String?=""
) {

}