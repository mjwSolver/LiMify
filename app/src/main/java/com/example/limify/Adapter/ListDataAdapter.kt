package com.example.limify01.Adapter

import Interface.CardListener
import Model.HistoryRecycle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.limify.R
import com.example.limify.databinding.CardHistoryBinding


class ListDataAdapter(val listHistory: ArrayList<HistoryRecycle>,val cardListener: CardListener):RecyclerView.Adapter<ListDataAdapter.viewHolder>() {

    class viewHolder (val itemView: View, val cardListener1: CardListener): RecyclerView.ViewHolder(itemView) {

        val binding = CardHistoryBinding.bind(itemView)

        fun setData(data: HistoryRecycle){
            binding.tipeCard.text = data.tipe
            binding.jenisCard.text = data.jenis
            binding.waktuCard.text = data.waktu
            binding.jangkaCard.text = data.jangkawaktu
            binding.keuanganCard.text = data.uang
            binding.catatanCard.text = data.catatan

            itemView.setOnClickListener{
                cardListener1.onCardClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.card_history, parent, false)
        return viewHolder(view, cardListener)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.setData(listHistory[position])
    }

    override fun getItemCount(): Int {
        return listHistory.size
    }
}