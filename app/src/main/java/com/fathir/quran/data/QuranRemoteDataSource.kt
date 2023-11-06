package com.fathir.quran.data

import android.util.Log
import com.fathir.quran.network.QuranApiService
import com.fathir.quran.network.SurahItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class QuranRemoteDataSource(private val apiService: QuranApiService) {
    suspend fun getListSurah() : Flow<NetworkResponse<List<SurahItem>>> =
        flow {
            try {
                val surahResponse = apiService.getListSurah()
                val listSurah = surahResponse.listSurah

                emit(NetworkResponse.Success(listSurah))

            } catch (e: Exception) {
                emit(NetworkResponse.Error(e.toString()))
                Log.e(QuranRemoteDataSource::class.java.simpleName, "error: " + e.localizedMessage)
            }

        }
}