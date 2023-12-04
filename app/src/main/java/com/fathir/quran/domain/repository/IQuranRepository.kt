package com.fathir.quran.domain.repository

import com.fathir.quran.data.Resource
import com.fathir.quran.domain.model.QuranEdition
import com.fathir.quran.domain.model.Surah
import kotlinx.coroutines.flow.Flow

interface IQuranRepository {
    fun getListSurah(): Flow<Resource<List<Surah>>>

    fun getDetailSurahWithQuranEdition(number: Int) : Flow<Resource<List<QuranEdition>>>

}