package com.fathir.quran.network

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class AyahResponse(

    @Json(name="code")
    val code: Int? = null,

    @Json(name="data")
    val quranEdition: List<QuranEdition>? = null,

    @Json(name="status")
    val status: String? = null
)


@JsonClass(generateAdapter = true)

data class AyahsItem(

    @Json(name="number")
    val number: Int? = null,

    @Json(name="numberInSurah")
    val numberInSurah: Int? = null,

    @Json(name="audio")
    val audio: String? = null,
)

@JsonClass(generateAdapter = true)

data class QuranEdition(

    @Json(name="number")
    val number: Int? = null,

    @Json(name="englishName")
    val englishName: String? = null,

    @Json(name="numberOfAyahs")
    val numberOfAyahs: Int? = null,

    @Json(name="revelationType")
    val revelationType: String? = null,

    @Json(name="name")
    val name: String? = null,

    @Json(name="ayahs")
    val ayahs: List<AyahsItem>? = null,

    @Json(name="englishNameTranslation")
    val englishNameTranslation: String? = null
)