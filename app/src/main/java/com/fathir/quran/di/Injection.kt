package com.fathir.quran.di

import com.fathir.quran.data.QuranRemoteDataSource
import com.fathir.quran.data.QuranRepository
import com.fathir.quran.network.ApiConfig

object Injection {

    fun provideQuranRepository(): QuranRepository {
        val apiService = ApiConfig.quranApiConfig
        val quranRemoteDataSource = QuranRemoteDataSource(apiService)
        return QuranRepository(quranRemoteDataSource)
    }
}