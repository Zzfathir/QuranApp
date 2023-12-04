package com.fathir.quran.presentation.quran

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.fathir.quran.data.QuranRepository
import com.fathir.quran.data.Resource
import com.fathir.quran.domain.model.QuranEdition
import com.fathir.quran.domain.model.Surah

class QuranViewModel(private val quranRepository: QuranRepository) : ViewModel() {
    fun getListSurah(): LiveData<Resource<List<Surah>>> = quranRepository.getListSurah().asLiveData()

    fun getDetailSurahWithQuranEdition(number: Int): LiveData<Resource<List<QuranEdition>>> =
        quranRepository.getDetailSurahWithQuranEdition(number).asLiveData()
}