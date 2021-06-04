package com.dev.pokemongo.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.dev.pokemongo.databinding.ListcapturedBinding
import com.dev.pokemongo.retrofit.response.CapturedResponse
import com.dev.pokemongo.ui.details.PokemonDetailsActivity

class CapturedAdapter(
    private var dataList: List<CapturedResponse>
) : RecyclerView.Adapter<CapturedAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListcapturedBinding.inflate(
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

        holder.itemView.setOnClickListener {
            val intentscreen = Intent(holder.itemView.context, PokemonDetailsActivity::class.java)
            intentscreen.putExtra("name", dataModel.name)
            intentscreen.putExtra("captureat", dataModel.captured_at)
            holder.itemView.context.startActivity(intentscreen)

        }

    }

    class ViewHolder(binding: ListcapturedBinding) : RecyclerView.ViewHolder(binding.root) {

        //  var captured: TextView = binding.capturedValue

    }


}
