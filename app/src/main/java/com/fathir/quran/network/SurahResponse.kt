package com.fathir.quran.network

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import javax.annotation.processing.Generated

@JsonClass(generateAdapter = true)
data class SurahResponse(

    @Json(name="code")
    val code: Int? = null,

    @Json(name="data")
    val listSurah: List<SurahItem>? = null,

    @Json(name="status")
    val status: String? = null
)

@Parcelize
@JsonClass(generateAdapter = true)
data class SurahItem(

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

    @Json(name="englishNameTranslation")
    val englishNameTranslation: String? = null
) :Parcelable