package com.fathir.quran.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fathir.quran.databinding.ActivityMainBinding
import com.fathir.quran.databinding.ItemAyahBinding
import com.fathir.quran.databinding.ItemSurahBinding
import com.fathir.quran.network.AyahsItem
import com.fathir.quran.network.QuranEdition

class SurahAdapter : RecyclerView.Adapter<SurahAdapter.MyViewHolder>() {
    private val  listAyah = ArrayList<AyahsItem>()
    private val quranEdition = ArrayList<QuranEdition>()
    private var onItemClickCallback: OnItemClickCallback? = null

    class MyViewHolder(val binding: ItemAyahBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        ItemAyahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listAyah.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val dataAyahs = listAyah[position]
        val quranAudio = quranEdition[1].ayahs?.get(position)
        val quranIndonesia = quranEdition[2].ayahs?.get(position)

        holder.binding.apply {
            itemNumberAyah.text = dataAyahs.numberInSurah.toString()
            itemAyah.text = dataAyahs.text
            itemTranslation.text = quranIndonesia?.text
            this.root.setOnClickListener {
                quranAudio?.let { data -> onItemClickCallback?.onItemClicked(data) }
            }

        }
    }

    fun setData(dataAyahs: List<AyahsItem>?, dataQuranEdition: List<QuranEdition>?) {
        if (dataAyahs == null || dataQuranEdition == null) return
        listAyah.clear()
        listAyah.addAll(dataAyahs)
        quranEdition.clear()
        quranEdition.addAll(dataQuranEdition)
    }

    fun setOnItemClicked(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: AyahsItem)
    }

}