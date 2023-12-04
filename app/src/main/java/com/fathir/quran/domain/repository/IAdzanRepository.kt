package com.fathir.quran.domain.repository

import androidx.lifecycle.LiveData
import com.fathir.quran.data.Resource
import com.fathir.quran.domain.model.City
import com.fathir.quran.domain.model.Jadwal
import kotlinx.coroutines.flow.Flow

interface IAdzanRepository {
    fun getLocation(): LiveData<List<String>>
    fun searchCity(city: String): Flow<Resource<List<City>>>
    fun getDailyAdzanTime(
        id: String,
        year: String,
        month: String,
        date: String
    ): Flow<Resource<Jadwal>>
}