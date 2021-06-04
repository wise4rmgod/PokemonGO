package com.dev.pokemongo.ui.captured

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.dev.pokemongo.R
import com.dev.pokemongo.adapter.CapturedAdapter
import com.dev.pokemongo.adapter.MyTeamAdapter
import com.dev.pokemongo.databinding.FragmentCapturedBinding
import com.dev.pokemongo.retrofit.response.CapturedResponse
import com.dev.pokemongo.retrofit.response.MyteamResponse
import com.dev.pokemongo.sharedpreference.AccountManager
import com.dev.pokemongo.ui.myteam.MyTeamViewModel
import com.example.urlshortenapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CapturedFragment : Fragment() {
    lateinit var binding: FragmentCapturedBinding
    val viewModel: CapturedViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCapturedBinding.inflate(inflater, container, false)
        val root = binding.root

        // list from remote server
        viewModel.getCaptured(AccountManager.getToken()).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data.let {
                            if (it != null) {
                                for (u in it) {
                                    viewModel.saveCaptured(u)
                                }
                            }

                        }
                    }
                    Status.ERROR -> {
                        resource.message?.let { it1 -> Log.d("geterror", it1) }
                    }
                    Status.LOADING -> {
                        resource.message?.let { it1 -> Log.d("getmessage", it1) }

                    }
                }
            }
        })

        // list of Local room db
        viewModel.getlocalCaptured.observe(viewLifecycleOwner, Observer {
            binding.capturedRecyclerview.adapter =
                CapturedAdapter(it as ArrayList<CapturedResponse>)
        })
        return root
    }

}