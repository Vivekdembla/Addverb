package com.security.addverb

import com.security.addverb.Model.Languages

fun ReturnLanguage(language : Languages):String {
    var st:String =""
    if(language.zho!="")
        st += "${language.zho}, "
    if(language.eng!="")
        st += "${language.eng}, "
    if(language.uzb!="")
        st += "${language.uzb}, "
    if(language.tur!="")
        st += "${language.tur}, "
    if(language.kaz!="")
        st += "${language.kaz}, "
    if(language.tha!="")
        st += "${language.tha}, "
    if(language.tam!="")
        st += "${language.tam}, "
    if(language.sin!="")
        st += "${language.sin}, "
    if(language.ben!="")
        st += "${language.ben}, "
    if(language.mon!="")
        st += "${language.mon}, "
    if(language.kat!="")
        st += "${language.kat}, "
    if(language.prs!="")
        st += "${language.prs}, "
    if(language.ind!="")
        st += "${language.ind}, "
    if(language.kir!="")
        st += "${language.kir}, "
    if(language.kor!="")
        st += "${language.kor}, "
    if(language.khm!="")
        st += "${language.khm}, "
    if(language.aze!="")
        st += "${language.aze}, "
    if(language.por!="")
        st += "${language.por}, "
    if(language.jpn!="")
        st += "${language.jpn}, "
    if(language.rus!="")
        st += "${language.rus}, "
    if(language.div!="")
        st += "${language.div}, "
    if(language.dzo!="")
        st += "${language.dzo}, "
    if(language.hye!="")
        st += "${language.hye}, "
    if(language.nep!="")
        st += "${language.nep}, "
    if(language.mya!="")
        st += "${language.mya}, "
    if(language.lao!="")
        st += "${language.lao}, "
    if(language.fas!="")
        st += "${language.fas}, "
    if(language.mia!="")
        st += "${language.mia}, "
    if(language.msa!="")
        st += "${language.msa}, "
    if(language.fra!="")
        st += "${language.fra}, "
    if(language.ara!="")
        st += "${language.ara}"
    return st
}