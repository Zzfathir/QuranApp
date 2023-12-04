package com.fathir.quran.di

import android.content.Context
import com.fathir.quran.data.network.RemoteDataSource
import com.fathir.quran.data.QuranRepository
import com.fathir.quran.data.local.Calenderpreferences
import com.fathir.quran.data.local.LocationPreferences
import com.fathir.quran.data.network.AdzanRepository
import com.fathir.quran.data.network.ApiConfig

object Injection {
    val quranApiService = ApiConfig.quranApiService
    val adzanApiService = ApiConfig.adzanApiService
    val remoteDataSource = RemoteDataSource(quranApiService, adzanApiService)
    fun provideQuranRepository(): QuranRepository {
        return QuranRepository(remoteDataSource)
    }


    fun provideAdzanRepository(context: Context): AdzanRepository{
        val locationPreferences = LocationPreferences(context)
        val calendarPreferences = Calenderpreferences()
        return AdzanRepository(remoteDataSource, locationPreferences,calendarPreferences )
    }
}