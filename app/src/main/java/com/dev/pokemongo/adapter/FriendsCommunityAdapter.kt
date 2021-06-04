package com.dev.pokemongo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.dev.pokemongo.databinding.ListcommunityBinding
import com.dev.pokemongo.retrofit.response.communityresponse.Foes
import com.dev.pokemongo.retrofit.response.communityresponse.Friends
import com.dev.pokemongo.ui.details.PokemonDetailsActivity

class FriendsCommunityAdapter(
    private var dataList: List<Friends>
) : RecyclerView.Adapter<FriendsCommunityAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListcommunityBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(
            binding
        )

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataList.get(position)

        holder.trainer.text = dataModel.pokemon.name
        holder.captured.text = dataModel.pokemon.captured_at

        holder.itemView.setOnClickListener {
            val intentscreen = Intent(holder.itemView.context, PokemonDetailsActivity::class.java)
            intentscreen.putExtra("name", dataModel.pokemon.name)
            intentscreen.putExtra("captureat", dataModel.pokemon.captured_at)
            holder.itemView.context.startActivity(intentscreen)
        }

    }

    class ViewHolder(binding: ListcommunityBinding) : RecyclerView.ViewHolder(binding.root) {
        var trainer: TextView = binding.trainer
        var captured: TextView = binding.captured

    }


}
