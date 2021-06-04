package com.dev.pokemongo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.dev.pokemongo.databinding.ListcommunityBinding
import com.dev.pokemongo.retrofit.response.communityresponse.Foes

class CommunityAdapter(
    private var dataList: List<Foes>
) : RecyclerView.Adapter<CommunityAdapter.ViewHolder>() {

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

            val bundle = bundleOf()
            //   dataModel.id.let { it1 -> bundle.putInt("id", it1) }

            //  holder.itemView.findNavController()
            //   .navigate(R.id.action_navigation_home_to_detailsViewFragment, bundle)
        }

    }

    class ViewHolder(binding: ListcommunityBinding) : RecyclerView.ViewHolder(binding.root) {
        var trainer: TextView = binding.trainer
        var captured: TextView = binding.captured

    }


}
