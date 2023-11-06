package com.fathir.quran.presentation.Quran

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.LinearLayoutManager
import com.fathir.quran.R
import com.fathir.quran.adapter.QuranAdapter
import com.fathir.quran.databinding.FragmentQuranBinding
import com.fathir.quran.presentation.ViewModelFactory


class QuranFragment : Fragment() {
    private var _binding : FragmentQuranBinding? = null
    private val binding get() = _binding as FragmentQuranBinding

    private val quranViewModel: QuranViewModel by viewModels { ViewModelFactory() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuranBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val quranViewModel = ViewModelProvider(this)[QuranViewModel::class.java]
        quranViewModel.getListSurah()
        quranViewModel.getListSurah().observe(viewLifecycleOwner){
            binding.rvQuran.apply {
                val mAdapter = QuranAdapter()
                mAdapter.setData(it.data)
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}