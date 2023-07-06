package com.example.talenthubapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.talenthubapp.databinding.ItemShowNameBinding

class RecyclerviewOfNameAdapter : RecyclerView.Adapter<RecyclerviewOfNameAdapter.RecyclerviewOfNameViewHolder>() {

    private var listOfName = ArrayList<String>()


    fun addedListOfName(list : List<String>) {
        this.listOfName.clear()
        this.listOfName.addAll(list)
        notifyDataSetChanged()
    }


    inner class RecyclerviewOfNameViewHolder(val binding : ItemShowNameBinding) : RecyclerView.ViewHolder(
        binding.root
    ) {
        fun bind(position : Int) {
            val itemNow = listOfName[position]
            binding.tvNameItemShowName.text = itemNow

            binding.layoutItemShowName.setOnClickListener {
                Toast.makeText(itemView.context, itemNow, Toast.LENGTH_SHORT).show()

                val i = Intent(itemView.context, MainActivity::class.java)
                itemView.context.startActivity(i)
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