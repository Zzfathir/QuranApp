package com.fathir.quran.domain.model

import com.fathir.quran.data.Resource

data class DailyAdzanResult(
    val listLocation : List<String>,
    val adzanTime: Resource<Jadwal>,
    val currentDate : List<String>
)