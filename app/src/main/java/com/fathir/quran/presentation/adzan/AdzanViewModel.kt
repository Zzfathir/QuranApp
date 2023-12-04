package com.fathir.quran.presentation.adzan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fathir.quran.data.Resource
import com.fathir.quran.data.network.AdzanRepository
import com.fathir.quran.domain.model.DailyAdzanResult

class AdzanViewModel(private val adzanRepository: AdzanRepository) : ViewModel() {
    fun getDailyAdzanTime(): LiveData<Resource<DailyAdzanResult>> =
        adzanRepository.getDailyAdzanTimeResult()


}