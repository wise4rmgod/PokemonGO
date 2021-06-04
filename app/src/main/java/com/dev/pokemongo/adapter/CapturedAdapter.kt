package com.dev.pokemongo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.dev.pokemongo.databinding.ListcapturedBinding
import com.dev.pokemongo.retrofit.response.CapturedResponse

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

       // holder.captured.text = dataModel.captured_at

        holder.itemView.setOnClickListener {

            val bundle = bundleOf()
            dataModel.id.let { it1 ->
                if (it1 != null) {
                    bundle.putInt("id", it1)
                }
            }
            dataModel.captured_at.let { it1 -> bundle.putString("id", it1) }

            //  holder.itemView.findNavController()
            //   .navigate(R.id.action_navigation_home_to_detailsViewFragment, bundle)
        }

    }

    class ViewHolder(binding: ListcapturedBinding) : RecyclerView.ViewHolder(binding.root) {

      //  var captured: TextView = binding.capturedValue

    }


}
