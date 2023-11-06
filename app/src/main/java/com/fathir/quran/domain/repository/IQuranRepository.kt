package com.fathir.quran.domain.repository

import com.fathir.quran.data.Resource
import com.fathir.quran.domain.model.Surah
import com.fathir.quran.network.SurahItem
import kotlinx.coroutines.flow.Flow

interface IQuranRepository {

    fun getListSurah(): Flow<Resource<List<Surah>>>
}