package com.fathir.quran.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fathir.quran.di.Injection.provideQuranRepository
import com.fathir.quran.presentation.Quran.QuranViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory: ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(QuranViewModel::class.java) -> {
                QuranViewModel(provideQuranRepository()) as T
            }
            else -> throw Throwable("Unknown ViewModel Class:" + modelClass.name)
        }
}