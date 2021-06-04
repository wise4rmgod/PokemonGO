package com.dev.pokemongo.ui.details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.dev.pokemongo.R
import com.dev.pokemongo.databinding.ActivityPokemonDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityPokemonDetailsBinding
    val viewModel: PokemonDetailsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val getname = intent.getStringExtra("name")
        val getcaptureat = intent.getStringExtra("captureat")

        binding = ActivityPokemonDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = getname
        binding.contentscroll.detailcaptureValue.text = getcaptureat

    }
}