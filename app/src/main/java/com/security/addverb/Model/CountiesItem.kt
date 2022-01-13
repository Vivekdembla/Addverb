package com.security.addverb.Model


data class CountiesItem(
    val borders: List<String>?= ArrayList<String>(),
    val capital: List<String>? = ArrayList<String>(),
    val currencies: Currencies?,
    val flags: Flags?,
    val languages: Languages?,
    val name: Name?,
    val population: Int? = 0,
    val region: String? = "",
    val subregion: String? = "",
)