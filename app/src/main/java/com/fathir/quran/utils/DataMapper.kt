package com.fathir.quran.utils

import com.fathir.quran.domain.model.Surah
import com.fathir.quran.network.SurahItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

object DataMapper {

    fun mapResponseToDomain(input: List<SurahItem>) : Flow<List<Surah>> {
        val listSurah = ArrayList<Surah>()
        input.map {
            val surah = Surah(
                number = it.number,
                englishName = it.englishName,
                numberOfAyahs = it.numberOfAyahs,
                revelationType = it.revelationType,
                name = it.name,
                englishNameTranslation = it.englishNameTranslation
            )
            listSurah.add(surah)
        }
        return flowOf(listSurah)
    }
}