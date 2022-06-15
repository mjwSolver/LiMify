package Adapter

import Interface.CardListener
import com.example.limify01.model.User
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.limify.R
import com.example.limify.databinding.CardUserBinding


class ListDataRVAdapter(val listUser: ArrayList<User>, val cardListener: CardListener):
    RecyclerView.Adapter<ListDataRVAdapter.viewHolder>() {

    class viewHolder (val itemView: View, val cardListener1: CardListener): RecyclerView.ViewHolder(itemView) {

        val binding = CardUserBinding.bind(itemView)

        fun setData(data: User){
            binding.namaCard.text = data.nama
            binding.emailCard.text = data.email
            binding.alamatCard.text = data.alamat
            if(data.imageUri.isNotEmpty()) {
                binding.pictureCard.setImageURI(Uri.parse(data.imageUri))
            }
            itemView.setOnClickListener{
                cardListener1.onCardClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.card_user, parent, false)
        return viewHolder(view, cardListener)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.setData(listUser[position])
    }

    override fun getItemCount(): Int {
        return listUser.size
    }


}