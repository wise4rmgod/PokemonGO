package com.dev.pokemongo.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dev.pokemongo.R
import com.dev.pokemongo.databinding.ActivityPokemonDetailsBinding


class DetailsFragment : Fragment() {
    lateinit var binding: ActivityPokemonDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

}