package com.fathir.quran.data

import com.fathir.quran.domain.model.Surah
import com.fathir.quran.domain.repository.IQuranRepository
import com.fathir.quran.network.SurahItem
import com.fathir.quran.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import javax.sql.CommonDataSource

class QuranRepository(private val remoteDataSource: QuranRemoteDataSource): IQuranRepository {
    override fun getListSurah(): Flow<Resource<List<Surah>>> {
        return object : NetworkBoundResource<List<Surah>, List<SurahItem>>() {
            override fun fetchFromNetwork(data: List<SurahItem>): Flow<List<Surah>> {
                return DataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<NetworkResponse<List<SurahItem>>> {
                return remoteDataSource.getListSurah()
            }

        }.asFlow()
    }

}