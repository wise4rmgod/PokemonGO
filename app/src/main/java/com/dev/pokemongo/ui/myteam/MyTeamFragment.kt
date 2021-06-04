package com.dev.pokemongo.ui.myteam

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.dev.pokemongo.R
import com.dev.pokemongo.adapter.MyTeamAdapter
import com.dev.pokemongo.databinding.FragmentMyTeamBinding
import com.dev.pokemongo.retrofit.response.MyteamResponse
import com.dev.pokemongo.sharedpreference.AccountManager
import com.dev.pokemongo.ui.explore.ExploreViewModel
import com.example.urlshortenapp.utils.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyTeamFragment : Fragment() {
    lateinit var binding: FragmentMyTeamBinding
    val viewModel: MyTeamViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMyTeamBinding.inflate(inflater, container, false)
        val root = binding.root

        viewModel.getMyTeam(AccountManager.getToken()).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {

                        resource.data.let {
                            if (it != null) {
                                for (u in it) {
                                    viewModel.saveTeam(u)
                                    /**    viewModel.getloct.observe(viewLifecycleOwner, Observer {
                                    for (yu in it)
                                    if (u != yu) {
                                    Log.d("roomdb", u.toString())
                                    viewModel.saveTeam(u)
                                    } else {
                                    Toast.makeText(
                                    activity,
                                    "Data exit ",
                                    Toast.LENGTH_SHORT
                                    ).show()
                                    }
                                    }) **/

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


        viewModel.getloct.observe(viewLifecycleOwner, Observer {
            binding.teamRecyclerview.adapter =
                MyTeamAdapter(it as ArrayList<MyteamResponse>)
        })


        return root
    }


}