package com.dev.pokemongo.adapter

import android.os.Environment
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.dev.pokemongo.databinding.ListteamBinding
import com.dev.pokemongo.retrofit.response.MyteamResponse

class MyTeamAdapter(
    private var dataList: List<MyteamResponse>
) : RecyclerView.Adapter<MyTeamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListteamBinding.inflate(
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

        holder.name.text = dataModel.name
        holder.captured.text = dataModel.captured_at
        holder.hp.text = dataModel.captured_lat_at.toString()

        holder.itemView.setOnClickListener {

            val bundle = bundleOf()
            dataModel.id.let { it1 -> bundle.putInt("id", it1) }

            //  holder.itemView.findNavController()
            //   .navigate(R.id.action_navigation_home_to_detailsViewFragment, bundle)
        }

    }

    class ViewHolder(binding: ListteamBinding) : RecyclerView.ViewHolder(binding.root) {
        var name: TextView = binding.nameValue
        var captured: TextView = binding.capturedValue
        var hp: TextView = binding.hpValue
        var type: TextView = binding.typeValue
    }


}
