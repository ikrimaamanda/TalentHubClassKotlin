package com.example.talenthubapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.talenthubapp.databinding.ItemShowNameBinding
import com.example.talenthubapp.networking.UserGitHubModel

class RecyclerviewOfNameAdapter : RecyclerView.Adapter<RecyclerviewOfNameAdapter.RecyclerviewOfNameViewHolder>() {

    private var listOfName = ArrayList<UserGitHubModel>()


    fun addedListOfUsers(list : List<UserGitHubModel>) {
        this.listOfName.clear()
        this.listOfName.addAll(list)
        notifyDataSetChanged()
    }


    inner class RecyclerviewOfNameViewHolder(private val binding : ItemShowNameBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(position : Int) {
            val itemNow = listOfName[position]
            binding.tvItemShowName.text = itemNow.userName

            Glide
                .with(itemView.context)
                .load(itemNow.avatarURL)
                .into(binding.ivItemShowName)

            binding.layoutItemShowName.setOnClickListener {
                Toast.makeText(itemView.context, itemNow.userName, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerviewOfNameViewHolder {
        return RecyclerviewOfNameViewHolder(
            ItemShowNameBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listOfName.size
    }

    override fun onBindViewHolder(holder: RecyclerviewOfNameViewHolder, position: Int) {
        holder.bind(position)
    }

}